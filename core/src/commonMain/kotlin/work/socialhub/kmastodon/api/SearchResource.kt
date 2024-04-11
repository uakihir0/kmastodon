package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.search.SearchSearchRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.search.SearchSearchResponse
import kotlin.js.JsExport

@JsExport
interface SearchResource {

    /**
     * Searching for content.
     */
    fun search(
        request: SearchSearchRequest
    ): Response<SearchSearchResponse>
}
