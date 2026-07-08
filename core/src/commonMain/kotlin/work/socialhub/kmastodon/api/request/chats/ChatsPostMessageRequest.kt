package work.socialhub.kmastodon.api.request.chats

import kotlin.js.JsExport

@JsExport
class ChatsPostMessageRequest {
    /** chat id */
    var id: String? = null

    /** message body (required unless mediaId is set) */
    var content: String? = null

    /** attachment media id (required unless content is set) */
    var mediaId: String? = null
}
