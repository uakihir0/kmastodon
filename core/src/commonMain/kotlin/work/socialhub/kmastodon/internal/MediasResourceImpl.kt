package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.MediasResource
import work.socialhub.kmastodon.api.request.medias.MediasPostMediaRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.medias.MediasPostMediaResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class MediasResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    MediasResource {

    override suspend fun postMedia(
        request: MediasPostMediaRequest
    ): Response<MediasPostMediaResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v2/media")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .file("file", request.name!!, request.bytes!!)
                .pwn("description", request.description)
                .forceMultipartFormData(true)
                .post()
        }
    }

    override fun postMediaBlocking(
        request: MediasPostMediaRequest
    ): Response<MediasPostMediaResponse> {
        return toBlocking {
            postMedia(request)
        }
    }
}
