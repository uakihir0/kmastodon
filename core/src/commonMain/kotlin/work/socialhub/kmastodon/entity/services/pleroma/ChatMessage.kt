package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.Attachment
import work.socialhub.kmastodon.entity.Emoji
import kotlin.js.JsExport

/**
 * Pleroma chat message.
 * https://docs.pleroma.social/backend/development/API/chats/
 */
@JsExport
@Serializable
class ChatMessage {

    @SerialName("id")
    var id: String? = null

    @SerialName("chat_id")
    var chatId: String? = null

    @SerialName("account_id")
    var accountId: String? = null

    @SerialName("content")
    var content: String? = null

    @SerialName("created_at")
    var createdAt: String? = null

    @SerialName("emojis")
    var emojis: Array<Emoji> = arrayOf()

    @SerialName("unread")
    var isUnread: Boolean = false

    @SerialName("attachment")
    var attachment: Attachment? = null

    @SerialName("idempotency_key")
    var idempotencyKey: String? = null
}
