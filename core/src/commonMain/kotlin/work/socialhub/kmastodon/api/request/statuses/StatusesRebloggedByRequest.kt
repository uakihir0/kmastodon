package work.socialhub.kmastodon.api.request.statuses

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class StatusesRebloggedByRequest {
    var id: String? = null
    var range: Range? = null
}