package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.emojireactions.EmojiReactionsReactRequest
import work.socialhub.kmastodon.api.request.emojireactions.EmojiReactionsReactionsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.emojireactions.EmojiReactionsReactResponse
import work.socialhub.kmastodon.api.response.emojireactions.EmojiReactionsReactionsResponse
import kotlin.js.JsExport

/**
 * Pleroma / Akkoma emoji reactions.
 * https://docs.pleroma.social/backend/development/API/pleroma_api/
 */
@JsExport
interface EmojiReactionsResource {

    /**
     * Getting emoji reactions of a status.
     * If request.emoji is set, only that reaction is returned.
     */
    suspend fun reactions(
        request: EmojiReactionsReactionsRequest
    ): Response<Array<EmojiReactionsReactionsResponse>>

    @JsExport.Ignore
    fun reactionsBlocking(
        request: EmojiReactionsReactionsRequest
    ): Response<Array<EmojiReactionsReactionsResponse>>

    /**
     * Adding an emoji reaction to a status.
     * Returns the updated status.
     */
    suspend fun react(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse>

    @JsExport.Ignore
    fun reactBlocking(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse>

    /**
     * Removing an emoji reaction from a status.
     * Returns the updated status.
     */
    suspend fun unreact(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse>

    @JsExport.Ignore
    fun unreactBlocking(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse>
}
