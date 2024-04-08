package work.socialhub.kmastodon.api.request.lists

import kotlin.js.JsExport

@JsExport
class ListsListAccountsRequest {
    var id: String? = null
    var limit: Int? = null
}