package work.socialhub.kmastodon.api.request.timelines

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class TimelinesConversationsRequest {
    var range: Range? = null
}