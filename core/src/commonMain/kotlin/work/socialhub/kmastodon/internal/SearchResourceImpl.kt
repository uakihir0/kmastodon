package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.SearchResource
import work.socialhub.kmastodon.api.request.search.SearchSearchRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.search.SearchSearchResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class SearchResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    SearchResource {

    override suspend fun search(
        request: SearchSearchRequest
    ): Response<SearchSearchResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v2/search")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .qwn("q", request.query)
                .qwn("resolve", request.resolve)
                .qwn("following", request.onlyFollowing)
                .qwn("limit", request.page?.limit)
                .qwn("offset", request.page?.offset)
                .get()
        }
    }

    override fun searchBlocking(
        request: SearchSearchRequest
    ): Response<SearchSearchResponse> {
        return toBlocking {
            search(request)
        }
    }
}
