package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.AppsResource
import work.socialhub.kmastodon.api.request.apps.AppsRegisterApplicationRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.apps.AppsRegisterApplicationResponse
import work.socialhub.kmastodon.util.MediaType

class AppsResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    AppsResource {

    /**
     * {@inheritDoc}
     */
    override fun registerApplication(
        request: AppsRegisterApplicationRequest
    ): Response<AppsRegisterApplicationResponse> = exec {
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
