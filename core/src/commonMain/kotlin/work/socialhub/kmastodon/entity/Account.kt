package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Account : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("username")
    var userName: String? = null

    @SerializedName("acct")
    var account: String? = null

    @SerializedName("display_name")
    var displayName: String? = null

    @SerializedName("locked")
    var isLocked: Boolean = false

    @SerializedName("bot")
    var bot: Boolean? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("followers_count")
    var followersCount: Long = 0

    @SerializedName("following_count")
    var followingCount: Long = 0

    @SerializedName("statuses_count")
    var statusesCount: Long = 0

    @SerializedName("note")
    var note: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    @SerializedName("avatar_static")
    var avatarStatic: String? = null

    @SerializedName("header")
    var header: String? = null

    @SerializedName("header_static")
    var headerStatic: String? = null

    @SerializedName("emojis")
    var emojis: Array<Emoji>

    @SerializedName("source")
    var source: AccountSource? = null

    @SerializedName("fields")
    var fields: Array<Field>

    // Pleroma
    @SerializedName("pleroma")
    var pleroma: PleromaAccount? = null
}
