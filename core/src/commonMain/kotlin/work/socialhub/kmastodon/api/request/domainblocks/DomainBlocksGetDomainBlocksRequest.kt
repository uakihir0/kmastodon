package work.socialhub.kmastodon.api.request.domainblocks

import work.socialhub.kmastodon.api.request.Page
import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class DomainBlocksGetDomainBlocksRequest {
    var range: Range? = null
    var page: Page? = null
}
