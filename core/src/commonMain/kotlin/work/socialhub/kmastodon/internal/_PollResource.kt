package work.socialhub.kmastodon.internal

import mastodon4j.api.PollResource
import mastodon4j.entity.Poll
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author uakihir0
 */
class _PollResource internal constructor(private val uri: String, accessToken: String) : PollResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)

    fun votePoll(id: String, choices: LongArray): Response<Poll> {
        return proceed(Poll::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/polls/{id}/votes")
                    .pathValue("id", id.toString())
            for (i in choices) {
                builder.param("choices[]", i)
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
