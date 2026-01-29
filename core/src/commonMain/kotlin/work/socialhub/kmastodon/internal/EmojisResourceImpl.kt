package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.EmojisResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.emojis.EmojisCustomEmojisResponse
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class EmojisResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    EmojisResource {

    override suspend fun customEmojis(
    ): Response<Array<EmojisCustomEmojisResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/custom_emojis")
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun customEmojisBlocking(
    ): Response<Array<EmojisCustomEmojisResponse>> {
        return toBlocking {
            customEmojis()
        }
    }
}
