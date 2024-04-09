package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PleromaStatus {

    @SerialName("content")
    var content: PleromaContent? = null

    @SerialName("conversation_id")
    var conversationId: Int = 0

    @SerialName("direct_conversation_id")
    var directConversationId: String? = null

    @SerialName("emoji_reactions")
    var emojiReactions: Array<PleromaReaction>? = null

    @SerialName("expires_at")
    var expiresAt: String? = null

    @SerialName("in_reply_to_account_acct")
    var inReplyToAccountAcct: String? = null

    @SerialName("local")
    var isLocal: Boolean = false

    @SerialName("parent_visible")
    var isParentVisible: Boolean = false

    @SerialName("pinned_at")
    var pinnedAt: String? = null

    @SerialName("spoiler_text")
    var spoilerText: PleromaContent? = null

    @SerialName("thread_muted")
    var isThreadMuted: Boolean = false
}
