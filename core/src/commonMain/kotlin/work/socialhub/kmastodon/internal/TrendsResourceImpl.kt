package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.TrendsResource
import work.socialhub.kmastodon.api.request.trends.TrendsTrendsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.trends.TrendsTrendsResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmpcommon.runBlocking

class TrendsResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    TrendsResource {

    override fun trends(
        request: TrendsTrendsRequest
    ): Response<Array<TrendsTrendsResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/trends")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .qwn("limit", request.limit)
                    .get()

            }
        }
    }
}
