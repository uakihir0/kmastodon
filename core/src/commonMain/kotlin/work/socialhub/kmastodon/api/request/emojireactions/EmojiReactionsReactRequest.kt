package work.socialhub.kmastodon.api.request.emojireactions

import kotlin.js.JsExport

@JsExport
class EmojiReactionsReactRequest {
    /** status id */
    var id: String? = null

    /** unicode emoji (or custom shortcode) to react with */
    var emoji: String? = null
}
