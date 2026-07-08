package work.socialhub.kmastodon.api.request.chats

import kotlin.js.JsExport

@JsExport
class ChatsByAccountRequest {
    /** account id */
    var accountId: String? = null
}
