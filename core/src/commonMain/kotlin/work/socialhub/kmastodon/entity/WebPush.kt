package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class WebPush {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("notification_type")
    var notificationType: String? = null

    @SerializedName("notification_id")
    var notificationId: Long? = null

    @SerializedName("preferred_locale")
    var preferredLocale: String? = null

    @SerializedName("access_token")
    var access_token: String? = null

    @SerializedName("icon")
    var icon: String? = null

    @SerializedName("body")
    var body: String? = null
}
