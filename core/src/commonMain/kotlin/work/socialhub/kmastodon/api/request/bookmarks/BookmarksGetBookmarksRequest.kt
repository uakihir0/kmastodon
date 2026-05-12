package work.socialhub.kmastodon.api.request.bookmarks

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class BookmarksGetBookmarksRequest {
    var range: Range? = null
}
