package work.socialhub.kmastodon.api.request.notifications

import work.socialhub.kmastodon.entity.Alert
import kotlin.js.JsExport

@JsExport
class NotificationsPostSubscriptionRequest {
    var endpoint: String? = null
    var p256dh: String? = null
    var auth: String? = null
    var alert: Alert? = null
}