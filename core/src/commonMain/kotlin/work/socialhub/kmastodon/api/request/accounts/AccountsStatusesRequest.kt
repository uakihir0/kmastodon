package work.socialhub.kmastodon.api.request.accounts

import work.socialhub.kmastodon.Range
import kotlin.js.JsExport

@JsExport
class AccountsStatusesRequest {
    var id: String? = null
    var onlyPinned: Boolean? = null
    var onlyMedia: Boolean? = null
    var excluedeReplies: Boolean? = null
    var excludeReblogs: Boolean? = null
    var range: Range? = null
}