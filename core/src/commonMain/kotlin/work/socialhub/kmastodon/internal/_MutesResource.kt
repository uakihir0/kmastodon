package work.socialhub.kmastodon.internal

import mastodon4j.api.MutesResource
import mastodon4j.entity.Account
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _MutesResource(private val uri: String, accessToken: String) : MutesResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)

    val mutes: Response<Array<Account>>
        get() =//TODO: need to support: max_id, since_id, limit

            proceed(Array<Account>::class.java) {
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/mutes")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get()
            }
}
