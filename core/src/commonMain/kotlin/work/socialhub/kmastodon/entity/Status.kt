package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Status : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("uri")
    var uri: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("account")
    var account: Account? = null

    @SerializedName("in_reply_to_id")
    var inReplyToId: String? = null

    @SerializedName("in_reply_to_account_id")
    var inReplyToAccountId: String? = null

    @SerializedName("reblog")
    var reblog: Status? = null

    @SerializedName("content")
    var content: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("reblogs_count")
    var reblogsCount: Long = 0

    @SerializedName("favourites_count")
    var favouritesCount: Long = 0

    @SerializedName("reblogged")
    var isReblogged: Boolean = false

    @SerializedName("favourited")
    var isFavourited: Boolean = false

    @SerializedName("sensitive")
    var isSensitive: Boolean = false

    @SerializedName("spoiler_text")
    var spoilerText: String? = null

    @SerializedName("visibility")
    var visibility: String? = null

    @SerializedName("media_attachments")
    var mediaAttachments: Array<Attachment>

    @SerializedName("mentions")
    var mentions: Array<Mention>

    @SerializedName("tags")
    var tags: Array<Tag>

    @SerializedName("emojis")
    var emojis: Array<Emoji>

    @SerializedName("application")
    var application: Application? = null

    @SerializedName("poll")
    var poll: Poll? = null

    // Pleroma
    @SerializedName("pleroma")
    var pleroma: PleromaStatus? = null
}
