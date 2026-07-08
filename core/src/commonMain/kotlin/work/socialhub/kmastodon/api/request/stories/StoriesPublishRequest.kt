package work.socialhub.kmastodon.api.request.stories

import kotlin.js.JsExport

@JsExport
class StoriesPublishRequest {
    /** id returned from the add (upload) step */
    var mediaId: String? = null

    /** optional caption */
    var caption: String? = null
}
