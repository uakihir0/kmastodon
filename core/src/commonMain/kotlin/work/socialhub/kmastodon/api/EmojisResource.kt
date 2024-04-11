package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.emojis.EmojisCustomEmojisResponse
import kotlin.js.JsExport

@JsExport
interface EmojisResource {

    /**
     * Get custom emojis.
     */
    fun customEmojis(
    ): Response<Array<EmojisCustomEmojisResponse>>
}
