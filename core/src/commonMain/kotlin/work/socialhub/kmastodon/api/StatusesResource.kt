package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.statuses.StatusesCardRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesContextRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesDeleteStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouritedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesReblogRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesRebloggedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnfavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnreblogRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.statuses.StatusesCardResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesContextResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesFavouriteResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesFavouritedByResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesPostStatusResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesReblogResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesRebloggedByResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesStatusResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesUnfavouriteResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesUnreblogResponse
import kotlin.js.JsExport

@JsExport
interface StatusesResource {

    /**
     * Fetching a status.
     */
    suspend fun status(
        request: StatusesStatusRequest
    ): Response<StatusesStatusResponse>

    @JsExport.Ignore
    fun statusBlocking(
        request: StatusesStatusRequest
    ): Response<StatusesStatusResponse>

    /**
     * Getting status context.
     */
    suspend fun context(
        request: StatusesContextRequest
    ): Response<StatusesContextResponse>

    @JsExport.Ignore
    fun contextBlocking(
        request: StatusesContextRequest
    ): Response<StatusesContextResponse>

    /**
     * Getting a card associated with a status.
     */
    suspend fun card(
        request: StatusesCardRequest
    ): Response<StatusesCardResponse>

    @JsExport.Ignore
    fun cardBlocking(
        request: StatusesCardRequest
    ): Response<StatusesCardResponse>

    /**
     * Getting who reblogged a status.
     */
    suspend fun rebloggedBy(
        request: StatusesRebloggedByRequest
    ): Response<Array<StatusesRebloggedByResponse>>

    @JsExport.Ignore
    fun rebloggedByBlocking(
        request: StatusesRebloggedByRequest
    ): Response<Array<StatusesRebloggedByResponse>>

    /**
     * Getting who favourited a status.
     */
    suspend fun favouritedBy(
        request: StatusesFavouritedByRequest
    ): Response<Array<StatusesFavouritedByResponse>>

    @JsExport.Ignore
    fun favouritedByBlocking(
        request: StatusesFavouritedByRequest
    ): Response<Array<StatusesFavouritedByResponse>>


    /**
     * Posting a new status.
     */
    suspend fun postStatus(
        request: StatusesPostStatusRequest
    ): Response<StatusesPostStatusResponse>

    @JsExport.Ignore
    fun postStatusBlocking(
        request: StatusesPostStatusRequest
    ): Response<StatusesPostStatusResponse>

    /**
     * Deleting a status.
     */
    suspend fun deleteStatus(
        request: StatusesDeleteStatusRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteStatusBlocking(
        request: StatusesDeleteStatusRequest
    ): ResponseUnit

    /**
     * Reblogging a status.
     */
    suspend fun reblog(
        request: StatusesReblogRequest
    ): Response<StatusesReblogResponse>

    @JsExport.Ignore
    fun reblogBlocking(
        request: StatusesReblogRequest
    ): Response<StatusesReblogResponse>

    /**
     * Unreblogging a status.
     */
    suspend fun unreblog(
        request: StatusesUnreblogRequest
    ): Response<StatusesUnreblogResponse>

    @JsExport.Ignore
    fun unreblogBlocking(
        request: StatusesUnreblogRequest
    ): Response<StatusesUnreblogResponse>

    /**
     * Favouriting a status.
     */
    suspend fun favourite(
        request: StatusesFavouriteRequest
    ): Response<StatusesFavouriteResponse>

    @JsExport.Ignore
    fun favouriteBlocking(
        request: StatusesFavouriteRequest
    ): Response<StatusesFavouriteResponse>

    /**
     * Unfavouriting a status.
     */
    suspend fun unfavourite(
        request: StatusesUnfavouriteRequest
    ): Response<StatusesUnfavouriteResponse>

    @JsExport.Ignore
    fun unfavouriteBlocking(
        request: StatusesUnfavouriteRequest
    ): Response<StatusesUnfavouriteResponse>
}
