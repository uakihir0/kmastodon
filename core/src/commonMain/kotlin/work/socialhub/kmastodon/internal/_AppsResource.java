package work.socialhub.kmastodon.internal;

import mastodon4j.api.AppsResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Application;
import mastodon4j.entity.ClientCredential;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _AppsResource implements AppsResource {

    private final String uri;

    _AppsResource(String uri) {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<ClientCredential> registerApplication(Application application, String redirectUris, String scopes) {
        return proceed(ClientCredential.class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/apps")
                    .param("client_name", application.getName())
                    .param("redirect_uris", redirectUris)
                    .param("scopes", scopes);

            if (application.getWebsite() != null && !application.getWebsite().isEmpty()) {
                builder.param("website", application.getWebsite());
            }

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .post();
        });
    }

}
