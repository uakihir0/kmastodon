package work.socialhub.kmastodon.api.request.emojireactions

import kotlin.js.JsExport

@JsExport
class EmojiReactionsReactionsRequest {
    /** status id */
    var id: String? = null

    /** optional emoji filter (single reaction) */
    var emoji: String? = null
}
