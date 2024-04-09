package work.socialhub.kmastodon.api.request.timelines

import work.socialhub.kmastodon.Range
import kotlin.js.JsExport

@JsExport
class TimelinesListTimelineRequest {
    var listId: String? = null
    var range: Range? = null
}