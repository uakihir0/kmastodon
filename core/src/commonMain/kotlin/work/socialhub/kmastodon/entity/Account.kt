package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.services.pleroma.PleromaAccount
import kotlin.js.JsExport

@JsExport
@Serializable
class Account {
    @SerialName("id")
    var id: String? = null

    @SerialName("username")
    var userName: String? = null

    @SerialName("acct")
    var account: String? = null

    @SerialName("display_name")
    var displayName: String? = null

    @SerialName("locked")
    var isLocked: Boolean = false

    @SerialName("bot")
    var bot: Boolean? = null

    @SerialName("created_at")
    var createdAt: String? = null

    @SerialName("followers_count")
    var followersCount: Int = 0

    @SerialName("following_count")
    var followingCount: Int = 0

    @SerialName("statuses_count")
    var statusesCount: Int = 0

    @SerialName("note")
    var note: String? = null

    @SerialName("url")
    var url: String? = null

    @SerialName("avatar")
    var avatar: String? = null

    @SerialName("avatar_static")
    var avatarStatic: String? = null

    @SerialName("header")
    var header: String? = null

    @SerialName("header_static")
    var headerStatic: String? = null

    @SerialName("emojis")
    var emojis: Array<Emoji>? = null

    @SerialName("source")
    var source: AccountSource? = null

    @SerialName("fields")
    var fields: Array<Field>? = null

    // Pleroma
    @SerialName("pleroma")
    var pleroma: PleromaAccount? = null
}
