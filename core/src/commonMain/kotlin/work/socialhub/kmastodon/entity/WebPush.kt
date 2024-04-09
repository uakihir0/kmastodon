package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class WebPush {

    @SerialName("title")
    var title: String? = null

    @SerialName("notification_type")
    var notificationType: String? = null

    @SerialName("notification_id")
    var notificationId: Int? = null

    @SerialName("preferred_locale")
    var preferredLocale: String? = null

    @SerialName("access_token")
    var access_token: String? = null

    @SerialName("icon")
    var icon: String? = null

    @SerialName("body")
    var body: String? = null
}
