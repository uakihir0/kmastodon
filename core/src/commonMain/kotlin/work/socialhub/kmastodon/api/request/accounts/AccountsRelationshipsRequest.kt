package work.socialhub.kmastodon.api.request.accounts

import kotlin.js.JsExport

@JsExport
class AccountsRelationshipsRequest {
    var ids: Array<String> = emptyArray()

    fun addId(id: String) {
        ids += id
    }
}