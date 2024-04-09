package work.socialhub.kmastodon.internal

import mastodon4j.api.FollowRequestsResource
import mastodon4j.entity.Account
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _FollowRequestsResource(private val uri: String, accessToken: String) : FollowRequestsResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)

    val followRequests: Response<Array<Account>>
        get() =//TODO: need to support: max_id, since_id, limit

            proceed(Array<Account>::class.java) {
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/follow_requests")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get()
            }

    fun authorizeFollowRequest(id: String): Response<java.lang.Void> {
        return proceed {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/follow_requests/{id}/authorize")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun rejectFollowRequest(id: String): Response<java.lang.Void> {
        return proceed {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/follow_requests/{id}/reject")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
