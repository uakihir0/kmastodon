package work.socialhub.kmastodon.api.request.accounts

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class AccountsFollowersRequest {
    var id: String? = null
    var range: Range? = null
}