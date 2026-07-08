package work.socialhub.kmastodon

import work.socialhub.kmastodon.entity.Account
import work.socialhub.kmastodon.entity.Notification
import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.entity.instancev1.InstanceV1
import work.socialhub.kmastodon.entity.instancev2.InstanceV2
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Offline deserialization tests against payloads shaped like various
 * Mastodon-compatible forks. These verify that (a) missing fields do not
 * crash decoding and (b) fork-specific extension fields are surfaced.
 */
class ForkCompatTest {

    @Test
    fun testPleromaStatusWithReactions() {
        // Pleroma omits many Mastodon fields (uri, spoiler_text, ...) and adds
        // a "pleroma" object with emoji reactions.
        val jsonStr = """
            {
              "id": "AGV",
              "content": "<p>hello from pleroma</p>",
              "account": { "id": "1", "username": "alice", "acct": "alice" },
              "visibility": "local",
              "pleroma": {
                "local": true,
                "conversation_id": 42,
                "emoji_reactions": [
                  { "name": "🔥", "count": 3, "me": true }
                ]
              }
            }
        """.trimIndent()

        val status = fromJson<Status>(jsonStr)
        assertEquals("AGV", status.id)
        assertEquals("local", status.visibility)
        // Missing fields fall back to defaults, not crashes.
        assertEquals("", status.uri)
        assertEquals("", status.spoilerText)
        assertNotNull(status.pleroma)
        assertEquals(true, status.pleroma?.isLocal)
        assertEquals(1, status.pleroma?.emojiReactions?.size)
        assertEquals(3, status.pleroma?.emojiReactions?.first()?.count)
    }

    @Test
    fun testGoToSocialStatusExtensions() {
        val jsonStr = """
            {
              "id": "01F8",
              "content": "gts post",
              "account": { "id": "9", "username": "bob", "acct": "bob" },
              "visibility": "public",
              "local_only": true,
              "interaction_policy": {
                "can_reply": {
                  "automatic_approval": ["public"],
                  "manual_approval": []
                }
              }
            }
        """.trimIndent()

        val status = fromJson<Status>(jsonStr)
        assertEquals(true, status.isLocalOnly)
        assertNotNull(status.interactionPolicy)
        assertEquals(
            listOf("public"),
            status.interactionPolicy?.canReply?.automaticApproval?.toList()
        )
    }

    @Test
    fun testFriendicaStatusExtensions() {
        val jsonStr = """
            {
              "id": "123",
              "content": "friendica post",
              "account": { "id": "5", "username": "carol", "acct": "carol" },
              "visibility": "public",
              "title": "A Title",
              "dislikes_count": 2,
              "disliked": true
            }
        """.trimIndent()

        val status = fromJson<Status>(jsonStr)
        assertEquals("A Title", status.title)
        assertEquals(2, status.dislikesCount)
        assertEquals(true, status.isDisliked)
    }

    @Test
    fun testAkkomaAccountExtension() {
        val jsonStr = """
            {
              "id": "7",
              "username": "dave",
              "acct": "dave",
              "akkoma": { "status_ttl_days": 30, "permit_followback": true },
              "web_visibility": "public"
            }
        """.trimIndent()

        val account = fromJson<Account>(jsonStr)
        assertEquals("dave", account.userName)
        assertEquals("", account.note) // omitted -> default
        assertNotNull(account.akkoma)
        assertEquals(30, account.akkoma?.statusTtlDays)
        assertEquals(true, account.akkoma?.permitFollowback)
        assertEquals("public", account.webVisibility)
    }

    @Test
    fun testPleromaNotificationExtension() {
        val jsonStr = """
            {
              "id": "n1",
              "type": "pleroma:emoji_reaction",
              "pleroma": { "is_seen": false }
            }
        """.trimIndent()

        val notification = fromJson<Notification>(jsonStr)
        // Unknown/fork-specific notification types are plain strings.
        assertEquals("pleroma:emoji_reaction", notification.type)
        assertNotNull(notification.pleroma)
        assertEquals(false, notification.pleroma?.isSeen)
    }

    @Test
    fun testGoToSocialInstanceV2WithMissingFields() {
        // GoToSocial / other forks may omit several top-level instance fields.
        val jsonStr = """
            {
              "domain": "gts.example",
              "title": "GtS",
              "version": "0.17.0"
            }
        """.trimIndent()

        val instance = fromJson<InstanceV2>(jsonStr)
        assertEquals("gts.example", instance.domain)
        assertEquals("0.17.0", instance.version)
        // Missing nested objects are null, missing arrays are empty.
        assertTrue(instance.rules.isEmpty())
        assertEquals(null, instance.configuration)
    }

    @Test
    fun testPleromaInstanceV1WithMissingFields() {
        // Pleroma may omit fields like urls/stats/email on the v1 instance.
        val jsonStr = """
            {
              "uri": "pleroma.example",
              "title": "Pleroma",
              "version": "2.7.2 (compatible; Pleroma 2.7.2)"
            }
        """.trimIndent()

        val instance = fromJson<InstanceV1>(jsonStr)
        assertEquals("pleroma.example", instance.uri)
        assertTrue(instance.version.contains("Pleroma"))
        assertEquals(null, instance.urls)
        assertEquals("", instance.email)
    }
}
