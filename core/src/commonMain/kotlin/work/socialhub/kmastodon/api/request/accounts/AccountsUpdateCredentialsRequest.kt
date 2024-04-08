package work.socialhub.kmastodon.api.request.accounts

import kotlin.js.JsExport

@JsExport
class AccountsUpdateCredentialsRequest {
    var displayName: String? = null
    var note: String? = null
    var avatar: String? = null
    var header: String? = null
}