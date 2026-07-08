package work.socialhub.kmastodon.api.request.chats

import work.socialhub.kmastodon.api.request.Range
import kotlin.js.JsExport

@JsExport
class ChatsChatsRequest {
    var withMuted: Boolean? = null
    var range: Range? = null
}
