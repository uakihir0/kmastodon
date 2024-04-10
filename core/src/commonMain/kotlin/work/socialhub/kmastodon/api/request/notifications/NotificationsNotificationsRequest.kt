package work.socialhub.kmastodon.api.request.notifications

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class NotificationsNotificationsRequest {
    var id: String? = null
    var range: Range? = null
    var types: Array<String>? = null
    var excludeTypes: Array<String>? = null
}