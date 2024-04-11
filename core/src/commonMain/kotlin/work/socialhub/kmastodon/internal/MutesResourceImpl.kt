package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.MutesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.mutes.MutesMutesResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType

class MutesResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    MutesResource {

    override fun mutes(
    ): Response<Array<MutesMutesResponse>> = exec {
        HttpRequest()
            .url("${uri}/api/v1/mutes")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .get()
    }
}
