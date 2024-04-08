package work.socialhub.kmastodon.api.request.accounts

import kotlin.js.JsExport

@JsExport
class AccountsSearchRequest {
    var query: String? = null
    var limit: Int? = null
}