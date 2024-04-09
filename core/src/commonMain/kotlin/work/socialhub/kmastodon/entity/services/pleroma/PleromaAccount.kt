package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PleromaAccount {
    @SerialName("accepts_chat_messages")
    var isAcceptsChatMessages: Boolean = false

    @SerialName("allow_following_move")
    var isAllowFollowingMove: Boolean = false

    @SerialName("ap_id")
    var apId: String? = null

    // TODO: 型の確認
    // @SerialName("background_image")
    // var backgroundImage: String? = null

    @SerialName("chat_token")
    var chatToken: String? = null

    @SerialName("email")
    var email: String? = null

    @SerialName("hide_favorites")
    var isHideFavorites: Boolean = false

    @SerialName("hide_followers")
    var isHideFollowers: Boolean = false

    @SerialName("hide_followers_count")
    var isHideFollowersCount: Boolean = false

    @SerialName("hide_follows")
    var isHideFollows: Boolean = false

    @SerialName("hide_follows_count")
    var isHideFollowsCount: Boolean = false

    @SerialName("is_admin")
    var isAdmin: Boolean = false

    @SerialName("is_confirmed")
    var isConfirmed: Boolean = false

    @SerialName("is_moderator")
    var isModerator: Boolean = false

    @SerialName("skip_thread_containment")
    var isSkipThreadContainment: Boolean = false

    @SerialName("unread_conversation_count")
    var unreadConversationCount: Int = 0

    @SerialName("unread_notifications_count")
    var unreadNotificationsCount: Int = 0
}
