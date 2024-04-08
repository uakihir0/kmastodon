package work.socialhub.kmastodon.internal

import mastodon4j.Page
import mastodon4j.api.SearchResource
import mastodon4j.entity.Results
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _SearchResource(private val uri: String, accessToken: String) : SearchResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)

    fun search(
        query: String?,
        resolve: Boolean,
        onlyFollowing: Boolean,
        page: Page?
    ): Response<Results> {
        return proceed(Results::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v2/search")
                    .query("q", query)
                    .query("resolve", resolve)
                    .query("following", onlyFollowing)
                    .header("Authorization", this.bearerToken)
                    .request(HttpMediaType.APPLICATION_JSON)
            if (page != null) {
                if (page.getLimit().isPresent()) {
                    builder.query("limit", page.getLimit().get())
                }
                if (page.getOffset().isPresent()) {
                    builder.query("offset", page.getOffset().get())
                }
            }
            builder.get()
        }
    }
}
