package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.trends.TrendsTrendsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.trends.TrendsTrendsResponse
import kotlin.js.JsExport

@JsExport
interface TrendsResource {

    /**
     * Retrieving trends.
     * (Since v3.0.0)
     */
    fun trends(
        request: TrendsTrendsRequest
    ): Response<Array<TrendsTrendsResponse>>
}
