package work.socialhub.kmastodon.api.request

import kotlin.js.JsExport

@JsExport
class Range {
    var maxId: String? = null
    var minId: String? = null
    var sinceId: String? = null
    var limit: Int? = null
}
