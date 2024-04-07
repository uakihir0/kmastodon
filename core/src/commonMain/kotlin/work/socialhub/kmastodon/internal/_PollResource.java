package work.socialhub.kmastodon.internal;

import mastodon4j.api.PollResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Poll;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author uakihir0
 */
public class _PollResource implements PollResource {

    private final String uri;
    private final String bearerToken;

    _PollResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Poll> votePoll(String id, long[] choices) {
        return proceed(Poll.class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/polls/{id}/votes")
                            .pathValue("id", String.valueOf(id));

            for (long i : choices) {
                builder.param("choices[]", i);
            }

            return builder.request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }
}
