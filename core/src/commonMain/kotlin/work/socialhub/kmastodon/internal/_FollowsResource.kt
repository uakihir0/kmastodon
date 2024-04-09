package work.socialhub.kmastodon.internal

import mastodon4j.api.FollowsResource
import mastodon4j.entity.Account
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _FollowsResource(private val uri: String, accessToken: String) : FollowsResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)

    fun remoteFollow(uri: String?): Response<Account> {
        return proceed(Account::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/follow_requests")
                .param("uri", uri)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
