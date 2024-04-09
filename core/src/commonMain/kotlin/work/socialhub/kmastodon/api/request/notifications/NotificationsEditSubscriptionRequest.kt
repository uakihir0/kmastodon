package work.socialhub.kmastodon.api.request.notifications

import work.socialhub.kmastodon.entity.Alert
import kotlin.js.JsExport

@JsExport
class NotificationsEditSubscriptionRequest {
    var alert: Alert? = null
}