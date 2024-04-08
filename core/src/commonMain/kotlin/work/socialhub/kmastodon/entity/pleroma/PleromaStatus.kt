package work.socialhub.kmastodon.entity.pleroma

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class PleromaStatus {
    @SerializedName("content")
    var content: PleromaContent? = null

    @SerializedName("conversation_id")
    var conversationId: Int = 0

    @SerializedName("direct_conversation_id")
    var directConversationId: String? = null

    @SerializedName("emoji_reactions")
    var emojiReactions: List<PleromaReaction>? = null

    @SerializedName("expires_at")
    var expiresAt: String? = null

    @SerializedName("in_reply_to_account_acct")
    var inReplyToAccountAcct: String? = null

    @SerializedName("local")
    var isLocal: Boolean = false

    @SerializedName("parent_visible")
    var isParentVisible: Boolean = false

    @SerializedName("pinned_at")
    var pinnedAt: String? = null

    @SerializedName("spoiler_text")
    var spoilerText: PleromaContent? = null

    @SerializedName("thread_muted")
    var isThreadMuted: Boolean = false
}
