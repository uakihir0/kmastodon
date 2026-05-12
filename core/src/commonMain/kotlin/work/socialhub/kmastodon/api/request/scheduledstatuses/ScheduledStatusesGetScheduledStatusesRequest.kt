package work.socialhub.kmastodon.api.request.scheduledstatuses

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class ScheduledStatusesGetScheduledStatusesRequest {
    var range: Range? = null
}
