package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.AppsResource
import work.socialhub.kmastodon.api.request.apps.AppsRegisterApplicationRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.apps.AppsRegisterApplicationResponse
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class AppsResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    AppsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun registerApplication(
        request: AppsRegisterApplicationRequest
    ): Response<AppsRegisterApplicationResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/apps")
                .accept(MediaType.JSON)
                .pwn("client_name", request.name)
                .pwn("redirect_uris", request.redirectUris)
                .pwn("scopes", request.scopes)
                .pwn("website", request.website)
                .post()
        }
    }

    override fun registerApplicationBlocking(
        request: AppsRegisterApplicationRequest
    ): Response<AppsRegisterApplicationResponse> {
        return toBlocking {
            registerApplication(request)
        }
    }
}
