package work.socialhub.kmastodon.internal

import mastodon4j.api.TrendResource
import mastodon4j.entity.Trend
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author uakihir0
 */
class _TrendResource internal constructor(private val uri: String, accessToken: String) : TrendResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)

    fun getTrends(limit: Long?): Response<Array<Trend>> {
        return proceed(Array<Trend>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/trends")
            if (limit != null) {
                builder.query("limit", limit)
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }
}
