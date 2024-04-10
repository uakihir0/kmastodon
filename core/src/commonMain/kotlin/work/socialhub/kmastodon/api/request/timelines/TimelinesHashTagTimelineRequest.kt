package work.socialhub.kmastodon.api.request.timelines

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class TimelinesHashTagTimelineRequest {
    var hashtag: String? = null
    var local: Boolean? = null
    var onlyMedia: Boolean? = null
    var range: Range? = null
}