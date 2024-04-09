package work.socialhub.kmastodon.api.request.reports

import kotlin.js.JsExport

@JsExport
class ReportsPostReportRequest {
    var accountId: String? = null
    var statusIds: Array<String>? = null
    var comment: String? = null
}