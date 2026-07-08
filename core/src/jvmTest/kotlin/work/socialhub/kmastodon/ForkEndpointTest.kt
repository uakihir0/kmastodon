package work.socialhub.kmastodon

import work.socialhub.kmastodon.entity.services.pixelfed.Collection
import work.socialhub.kmastodon.entity.services.pixelfed.Story
import work.socialhub.kmastodon.entity.services.pleroma.Chat
import work.socialhub.kmastodon.entity.services.pleroma.ChatMessage
import work.socialhub.kmastodon.entity.services.pleroma.PleromaReaction
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Offline deserialization tests for the fork-specific endpoint payloads,
 * plus factory-type checks for the Pleroma/Pixelfed clients.
 */
class ForkEndpointTest {

    @Test
    fun testPleromaReactionsList() {
        // Pleroma returns full accounts.
        val jsonStr = """
            [
              {
                "name": "🔥",
                "count": 2,
                "me": true,
                "accounts": [
                  { "id": "1", "username": "a", "acct": "a" },
                  { "id": "2", "username": "b", "acct": "b" }
                ]
              }
            ]
        """.trimIndent()

        val reactions = fromJson<Array<PleromaReaction>>(jsonStr)
        assertEquals(1, reactions.size)
        assertEquals("🔥", reactions.first().name)
        assertEquals(2, reactions.first().count)
        assertTrue(reactions.first().isMe)
        assertEquals(2, reactions.first().accounts?.size)
        assertNull(reactions.first().accountIds)
    }

    @Test
    fun testAkkomaReactionsListWithAccountIds() {
        // Akkoma 3.2+ returns account_ids instead of full accounts.
        val jsonStr = """
            [
              { "name": "☕", "count": 2, "me": false, "account_ids": ["u1", "u2"] }
            ]
        """.trimIndent()

        val reactions = fromJson<Array<PleromaReaction>>(jsonStr)
        assertEquals(2, reactions.first().count)
        assertEquals(listOf("u1", "u2"), reactions.first().accountIds?.toList())
        assertNull(reactions.first().accounts)
    }

    @Test
    fun testPleromaChatAndMessage() {
        val chatJson = """
            {
              "id": "chat1",
              "account": { "id": "9", "username": "carol", "acct": "carol" },
              "unread": 3,
              "updated_at": "2024-01-01T00:00:00.000Z",
              "last_message": {
                "id": "m1",
                "chat_id": "chat1",
                "account_id": "9",
                "content": "hi",
                "unread": true
              }
            }
        """.trimIndent()

        val chat = fromJson<Chat>(chatJson)
        assertEquals("chat1", chat.id)
        assertEquals(3, chat.unread)
        assertEquals("carol", chat.account?.userName)
        assertNotNull(chat.lastMessage)
        assertEquals("hi", chat.lastMessage?.content)
        assertTrue(chat.lastMessage?.isUnread == true)
    }

    @Test
    fun testChatMessageMinimal() {
        // Attachment-only message: content omitted must not crash.
        val jsonStr = """{ "id": "m2", "chat_id": "c", "account_id": "9" }"""
        val message = fromJson<ChatMessage>(jsonStr)
        assertEquals("m2", message.id)
        assertNull(message.content)
        assertTrue(message.emojis.isEmpty())
    }

    @Test
    fun testPixelfedStoryAndCollection() {
        val storyJson = """
            { "id": "s1", "type": "photo", "src": "https://ex/s.jpg", "duration": 10, "seen": false }
        """.trimIndent()
        val story = fromJson<Story>(storyJson)
        assertEquals("s1", story.id)
        assertEquals("photo", story.type)
        assertEquals(10, story.duration)

        val collectionJson = """
            { "id": "c1", "title": "My Collection", "post_count": 5 }
        """.trimIndent()
        val collection = fromJson<Collection>(collectionJson)
        assertEquals("c1", collection.id)
        assertEquals("My Collection", collection.title)
        assertEquals(5, collection.postCount)
    }

    @Test
    fun testForkFactoriesReturnTypedClients() {
        // Compile-time + runtime check that fork factories expose fork resources.
        val pleroma: Pleroma = MastodonFactory.pleroma("https://pleroma.example", "token")
        assertNotNull(pleroma.emojiReactions())
        assertNotNull(pleroma.chats())
        assertNotNull(pleroma.pleromaExtras())
        // Mastodon API is still available on the fork client.
        assertNotNull(pleroma.statuses())

        val pixelfed: Pixelfed = MastodonFactory.pixelfed("https://pixelfed.example", "token")
        assertNotNull(pixelfed.stories())
        assertNotNull(pixelfed.collections())
        assertNotNull(pixelfed.timelines())
    }
}
