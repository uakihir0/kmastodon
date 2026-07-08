package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.services.akkoma.AkkomaAccount
import work.socialhub.kmastodon.entity.services.pleroma.PleromaAccount
import kotlin.js.JsExport

/**
 * https://docs.joinmastodon.org/entities/Account/
 */
@JsExport
@Serializable
class Account {

    @SerialName("id")
    var id: String = ""

    @SerialName("username")
    var userName: String = ""

    @SerialName("acct")
    var account: String = ""

    @SerialName("url")
    var url: String = ""

    @SerialName("display_name")
    var displayName: String = ""

    @SerialName("note")
    var note: String = ""

    @SerialName("avatar")
    var avatar: String = ""

    @SerialName("avatar_static")
    var avatarStatic: String? = null

    @SerialName("header")
    var header: String = ""

    @SerialName("header_static")
    var headerStatic: String? = null

    @SerialName("locked")
    var isLocked: Boolean = false

    @SerialName("fields")
    var fields: Array<Field> = arrayOf()

    @SerialName("emojis")
    var emojis: Array<Emoji> = arrayOf()

    @SerialName("bot")
    var isBot: Boolean = false

    @SerialName("group")
    var isGroup: Boolean = false

    @SerialName("discoverable")
    var isDiscoverable: Boolean? = null

    @SerialName("noindex")
    var isNoindex: Boolean? = null

    @SerialName("moved")
    var moved: Account? = null

    @SerialName("suspended")
    var isSuspended: Boolean = false

    @SerialName("limited")
    var isLimited: Boolean = false

    @SerialName("created_at")
    var createdAt: String = ""

    @SerialName("last_status_at")
    var lastStatusAt: String? = null

    @SerialName("statuses_count")
    var statusesCount: Int = 0

    @SerialName("followers_count")
    var followersCount: Int = 0

    @SerialName("following_count")
    var followingCount: Int = 0

    /* credential account only */
    @SerialName("source")
    var source: AccountSource? = null

    /* credential account only */
    @SerialName("role")
    var role: Role? = null

    /* Pleroma */
    @SerialName("pleroma")
    var pleroma: PleromaAccount? = null

    /* Akkoma */
    @SerialName("akkoma")
    var akkoma: AkkomaAccount? = null

    /* GoToSocial */
    @SerialName("web_visibility")
    var webVisibility: String? = null
}
