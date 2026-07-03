package work.socialhub.kmastodon.api.request.statuses

import kotlin.js.JsExport

@JsExport
class StatusesEditStatusRequest {
    var id: String? = null
    var status: String? = null
    var spoilerText: String? = null
    var sensitive: Boolean? = null
    var language: String? = null
    var mediaIds: Array<String>? = null

    var pollOptions: Array<String>? = null
    var pollExpiresIn: Int? = null
    var pollMultiple: Boolean? = null
    var pollHideTotals: Boolean? = null
}
