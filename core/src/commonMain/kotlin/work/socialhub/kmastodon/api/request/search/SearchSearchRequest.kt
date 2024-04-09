package work.socialhub.kmastodon.api.request.search

import work.socialhub.kmastodon.Page
import kotlin.js.JsExport

@JsExport
class SearchSearchRequest {
    var query: String? = null
    var resolve: Boolean? = null
    var onlyFollowing: Boolean? = null
    var page: Page? = null
}