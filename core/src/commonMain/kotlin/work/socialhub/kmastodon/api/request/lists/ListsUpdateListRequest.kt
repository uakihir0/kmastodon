package work.socialhub.kmastodon.api.request.lists

import kotlin.js.JsExport

@JsExport
class ListsUpdateListRequest {
    var id: String? = null
    var title: String? = null
}