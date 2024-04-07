package work.socialhub.kmastodon.internal;

import mastodon4j.api.TrendResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Trend;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author uakihir0
 */
public class _TrendResource implements TrendResource {

    private final String uri;
    private final String bearerToken;

    _TrendResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Trend[]> getTrends(Long limit) {
        return proceed(Trend[].class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/trends");

            if (limit != null) {
                builder.query("limit", limit);
            }

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }
}
