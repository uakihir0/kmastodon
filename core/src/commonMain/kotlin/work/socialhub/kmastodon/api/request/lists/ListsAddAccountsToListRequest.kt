package work.socialhub.kmastodon.api.request.lists

import kotlin.js.JsExport

@JsExport
class ListsAddAccountsToListRequest {
    var id: String? = null
    var accountIds: Array<String> = emptyArray()

    fun addAccountId(accountId: String) {
        accountIds += accountId
    }
}