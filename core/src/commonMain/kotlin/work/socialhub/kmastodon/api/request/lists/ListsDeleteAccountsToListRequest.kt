package work.socialhub.kmastodon.api.request.lists

import kotlin.js.JsExport

@JsExport
class ListsDeleteAccountsToListRequest {
    var id: String? = null
    var accountIds: Array<String> = emptyArray()

    fun addAccountId(accountId: String) {
        accountIds += accountId
    }
}