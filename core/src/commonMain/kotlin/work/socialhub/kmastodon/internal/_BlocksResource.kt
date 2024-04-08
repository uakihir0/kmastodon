package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.BlocksResource
import mastodon4j.entity.Account
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _BlocksResource(private val uri: String, accessToken: String) : BlocksResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)

    val blocks: Response<Array<Account>>
        get() = this.getBlocks(null)

    fun getBlocks(range: Range?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/blocks")
            if (range != null) {
                if (range.getLimit().isPresent()) {
                    builder.query("limit", range.getLimit().get())
                }
                if (range.getSinceId().isPresent()) {
                    builder.query("since_id", range.getSinceId().get())
                }
                if (range.getMaxId().isPresent()) {
                    builder.query("max_id", range.getMaxId().get())
                }
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }
}
