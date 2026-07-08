package work.socialhub.kmastodon

import work.socialhub.kmastodon.api.ChatsResource
import work.socialhub.kmastodon.api.EmojiReactionsResource
import work.socialhub.kmastodon.api.PleromaExtrasResource
import kotlin.js.JsExport

/**
 * Pleroma / Akkoma client. Extends [Mastodon] with Pleroma-specific
 * resources; all standard Mastodon resources remain available.
 */
@JsExport
interface Pleroma : Mastodon {

    fun emojiReactions(): EmojiReactionsResource

    fun chats(): ChatsResource

    fun pleromaExtras(): PleromaExtrasResource
}
