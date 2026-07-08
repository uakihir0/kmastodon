package work.socialhub.kmastodon.api.request.pleroma

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class PleromaQuotesRequest {
    /** status id */
    var id: String? = null
    var range: Range? = null
}
