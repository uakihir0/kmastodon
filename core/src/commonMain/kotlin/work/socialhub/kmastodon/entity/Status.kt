package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.filter.Filter
import work.socialhub.kmastodon.entity.services.pleroma.PleromaStatus
import kotlin.js.JsExport

/**
 * https://docs.joinmastodon.org/entities/Status/
 */
@JsExport
@Serializable
class Status {

    @SerialName("id")
    lateinit var id: String

    @SerialName("uri")
    lateinit var uri: String

    @SerialName("created_at")
    lateinit var createdAt: String

    @SerialName("account")
    lateinit var account: Account

    @SerialName("content")
    lateinit var content: String

    @SerialName("visibility")
    lateinit var visibility: String

    @SerialName("sensitive")
    var isSensitive: Boolean = false

    @SerialName("spoiler_text")
    lateinit var spoilerText: String

    @SerialName("media_attachments")
    var mediaAttachments: Array<Attachment> = arrayOf()

    @SerialName("application")
    var application: Application? = null

    @SerialName("mentions")
    var mentions: Array<Mention> = arrayOf()

    @SerialName("tags")
    var tags: Array<Tag> = arrayOf()

    @SerialName("emojis")
    var emojis: Array<Emoji> = arrayOf()

    @SerialName("reblogs_count")
    var reblogsCount: Int = 0

    @SerialName("favourites_count")
    var favouritesCount: Int = 0

    @SerialName("replies_count")
    var repliesCount: Int = 0

    @SerialName("url")
    var url: String? = null

    @SerialName("in_reply_to_id")
    var inReplyToId: String? = null

    @SerialName("in_reply_to_account_id")
    var inReplyToAccountId: String? = null

    @SerialName("reblog")
    var reblog: Status? = null

    @SerialName("poll")
    var poll: Poll? = null

    @SerialName("card")
    var card: Card? = null

    @SerialName("language")
    var language: String? = null

    @SerialName("text")
    var text: String? = null

    @SerialName("edited_at")
    var editedAt: String? = null

    @SerialName("reblogged")
    var isReblogged: Boolean = false

    @SerialName("favourited")
    var isFavourited: Boolean = false

    @SerialName("muted")
    var isMuted: Boolean = false

    @SerialName("bookmarked")
    var isBookmarked: Boolean = false

    @SerialName("pinned")
    var isPinned: Boolean = false

    @SerialName("filtered")
    var filtered: Array<Filter> = arrayOf()

    /** Pleroma */
    @SerialName("pleroma")
    var pleroma: PleromaStatus? = null
}
