package work.socialhub.kmastodon.api.request.timelines

import work.socialhub.kmastodon.Range
import kotlin.js.JsExport

@JsExport
class TimelinesPublicTimelineRequest {
    var local: Boolean? = null
    var onlyMedia: Boolean? = null
    var range: Range? = null
}