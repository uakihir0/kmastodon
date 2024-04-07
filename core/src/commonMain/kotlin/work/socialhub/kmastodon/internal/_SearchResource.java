package work.socialhub.kmastodon.internal;

import mastodon4j.Page;
import mastodon4j.api.SearchResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Results;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _SearchResource implements SearchResource {

    private final String uri;
    private final String bearerToken;

    _SearchResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Results> search(
            String query,
            boolean resolve,
            boolean onlyFollowing,
            Page page) {

        return proceed(Results.class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v2/search")
                            .query("q", query)
                            .query("resolve", resolve)
                            .query("following", onlyFollowing)
                            .header("Authorization", this.bearerToken)
                            .request(HttpMediaType.APPLICATION_JSON);

            if (page != null) {
                if (page.getLimit().isPresent()) {
                    builder.query("limit", page.getLimit().get());
                }
                if (page.getOffset().isPresent()) {
                    builder.query("offset", page.getOffset().get());
                }
            }

            return builder.get();
        });
    }

}
