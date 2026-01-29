package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.MutesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.mutes.MutesMutesResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class MutesResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    MutesResource {

    override suspend fun mutes(
    ): Response<Array<MutesMutesResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/mutes")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun mutesBlocking(
    ): Response<Array<MutesMutesResponse>> {
        return toBlocking {
            mutes()
        }
    }
}
