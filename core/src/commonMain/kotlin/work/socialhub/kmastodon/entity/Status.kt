package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.services.pleroma.PleromaStatus
import kotlin.js.JsExport


@JsExport
@Serializable
class Status {

    @SerialName("id")
    var id: String? = null

    @SerialName("uri")
    var uri: String? = null

    @SerialName("url")
    var url: String? = null

    @SerialName("account")
    var account: Account? = null

    @SerialName("in_reply_to_id")
    var inReplyToId: String? = null

    @SerialName("in_reply_to_account_id")
    var inReplyToAccountId: String? = null

    @SerialName("reblog")
    var reblog: Status? = null

    @SerialName("content")
    var content: String? = null

    @SerialName("created_at")
    var createdAt: String? = null

    @SerialName("reblogs_count")
    var reblogsCount: Int = 0

    @SerialName("favourites_count")
    var favouritesCount: Int = 0

    @SerialName("reblogged")
    var isReblogged: Boolean = false

    @SerialName("favourited")
    var isFavourited: Boolean = false

    @SerialName("sensitive")
    var isSensitive: Boolean = false

    @SerialName("spoiler_text")
    var spoilerText: String? = null

    @SerialName("visibility")
    var visibility: String? = null

    @SerialName("media_attachments")
    var mediaAttachments: Array<Attachment>? = null

    @SerialName("mentions")
    var mentions: Array<Mention>? = null

    @SerialName("tags")
    var tags: Array<Tag>? = null

    @SerialName("emojis")
    var emojis: Array<Emoji>? = null

    @SerialName("application")
    var application: Application? = null

    @SerialName("poll")
    var poll: Poll? = null

    /** Pleroma */
    @SerialName("pleroma")
    var pleroma: PleromaStatus? = null
}
