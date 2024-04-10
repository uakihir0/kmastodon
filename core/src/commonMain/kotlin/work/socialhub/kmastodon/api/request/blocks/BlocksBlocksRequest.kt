package work.socialhub.kmastodon.api.request.blocks

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class BlocksBlocksRequest {
    var range: Range? = null
}