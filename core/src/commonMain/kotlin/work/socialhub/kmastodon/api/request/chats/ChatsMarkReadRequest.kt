package work.socialhub.kmastodon.api.request.chats

import kotlin.js.JsExport

@JsExport
class ChatsMarkReadRequest {
    /** chat id */
    var id: String? = null

    /** id of the last read message */
    var lastReadId: String? = null
}
