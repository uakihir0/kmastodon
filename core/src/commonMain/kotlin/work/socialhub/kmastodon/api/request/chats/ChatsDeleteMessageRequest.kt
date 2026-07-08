package work.socialhub.kmastodon.api.request.chats

import kotlin.js.JsExport

@JsExport
class ChatsDeleteMessageRequest {
    /** chat id */
    var id: String? = null

    /** message id */
    var messageId: String? = null
}
