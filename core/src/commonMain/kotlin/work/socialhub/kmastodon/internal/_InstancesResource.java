package work.socialhub.kmastodon.internal;

import mastodon4j.api.InstancesResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Instance;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _InstancesResource implements InstancesResource {

    private final String uri;

    _InstancesResource(String uri) {
        this.uri = uri;
    }

    @Override
    public Response<Instance> getInstance() {
        return proceed(Instance.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/instance")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .get();
        });
    }

}
