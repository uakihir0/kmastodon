package work.socialhub.kmastodon.api.request.medias

import kotlin.js.JsExport

@JsExport
class MediasPostMediaRequest {
    var bytes: ByteArray? = null
    var name: String? = null
    var description: String? = null
}