package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.medias.MediasPostMediaRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.medias.MediasPostMediaResponse
import kotlin.js.JsExport

@JsExport
interface MediasResource {

    /**
     * Uploading a media attachment.
     */
    fun postMedia(
        request: MediasPostMediaRequest
    ): Response<MediasPostMediaResponse>
}
