package work.socialhub.kmastodon.internal

import mastodon4j.api.AppsResource
import mastodon4j.entity.Application
import mastodon4j.entity.ClientCredential
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _AppsResource(private val uri: String) : AppsResource {
    /**
     * {@inheritDoc}
     */
    fun registerApplication(
        application: Application,
        redirectUris: String?,
        scopes: String?
    ): Response<ClientCredential> {
        return proceed(ClientCredential::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/apps")
                .param("client_name", application.getName())
                .param("redirect_uris", redirectUris)
                .param("scopes", scopes)
            if (application.getWebsite() != null && !application.getWebsite().isEmpty()) {
                builder.param("website", application.getWebsite())
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .post()
        }
    }
}
