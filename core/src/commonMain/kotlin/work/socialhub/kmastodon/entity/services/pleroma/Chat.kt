package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.Account
import kotlin.js.JsExport

/**
 * Pleroma chat.
 * https://docs.pleroma.social/backend/development/API/chats/
 */
@JsExport
@Serializable
class Chat {

    @SerialName("id")
    var id: String? = null

    @SerialName("account")
    var account: Account? = null

    @SerialName("unread")
    var unread: Int = 0

    @SerialName("last_message")
    var lastMessage: ChatMessage? = null

    @SerialName("updated_at")
    var updatedAt: String? = null
}
