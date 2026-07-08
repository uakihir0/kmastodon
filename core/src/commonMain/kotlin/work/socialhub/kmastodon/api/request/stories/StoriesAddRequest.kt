package work.socialhub.kmastodon.api.request.stories

import kotlin.js.JsExport

@JsExport
class StoriesAddRequest {
    /** media bytes to upload */
    var bytes: ByteArray? = null
    var name: String? = null

    /** optional duration in seconds */
    var duration: Int? = null
}
