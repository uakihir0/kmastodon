package work.socialhub.kmastodon.api.request.timelines

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class TimelinesHomeTimelineRequest {
    var range: Range? = null
}