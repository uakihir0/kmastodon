package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.medias.MediasPostMediaRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.medias.MediasPostMediaResponse

interface MediaResource {

    /**
     * Uploading a media attachment.
     */
    fun postMedia(
        request: MediasPostMediaRequest
    ): Response<MediasPostMediaResponse>
}
