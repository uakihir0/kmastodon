package work.socialhub.kmastodon.entity.pleroma

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class PleromaAccount {
    @SerializedName("accepts_chat_messages")
    var isAcceptsChatMessages: Boolean = false

    @SerializedName("allow_following_move")
    var isAllowFollowingMove: Boolean = false

    @SerializedName("ap_id")
    var apId: String? = null

    @SerializedName("background_image")
    var backgroundImage: Any? = null

    @SerializedName("chat_token")
    var chatToken: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("hide_favorites")
    var isHideFavorites: Boolean = false

    @SerializedName("hide_followers")
    var isHideFollowers: Boolean = false

    @SerializedName("hide_followers_count")
    var isHideFollowersCount: Boolean = false

    @SerializedName("hide_follows")
    var isHideFollows: Boolean = false

    @SerializedName("hide_follows_count")
    var isHideFollowsCount: Boolean = false

    @SerializedName("is_admin")
    var isAdmin: Boolean = false

    @SerializedName("is_confirmed")
    var isConfirmed: Boolean = false

    @SerializedName("is_moderator")
    var isModerator: Boolean = false

    @SerializedName("skip_thread_containment")
    var isSkipThreadContainment: Boolean = false

    @SerializedName("unread_conversation_count")
    var unreadConversationCount: Int = 0

    @SerializedName("unread_notifications_count")
    var unreadNotificationsCount: Int = 0
}
