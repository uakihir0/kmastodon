package work.socialhub.kmastodon.internal;

import mastodon4j.Range;
import mastodon4j.api.FavouritesResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Status;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import java.util.function.Supplier;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _FavouritesResource implements FavouritesResource {

    private final String uri;
    private final String bearerToken;
    private final Supplier<Service> service;

    _FavouritesResource(Supplier<Service> service, String uri, String accessToken) {
        this.service = service;
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Status[]> getFavourites() {
        return this.getFavourites(null);
    }

    @Override
    public Response<Status[]> getFavourites(Range range) {
        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/favourites");

            _PagingUtility.setPagingParams(builder, range, service.get());
            
            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }
}
