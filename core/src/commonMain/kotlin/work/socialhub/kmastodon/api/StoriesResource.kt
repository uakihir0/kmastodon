package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.stories.StoriesAddRequest
import work.socialhub.kmastodon.api.request.stories.StoriesPublishRequest
import work.socialhub.kmastodon.api.request.stories.StoriesSelfExpireRequest
import work.socialhub.kmastodon.api.request.stories.StoriesViewersRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.stories.StoriesStoryResponse
import work.socialhub.kmastodon.api.response.stories.StoriesViewerResponse
import kotlin.js.JsExport

/**
 * Pixelfed stories.
 * https://github.com/pixelfed/pixelfed/blob/dev/routes/api.php
 */
@JsExport
interface StoriesResource {

    /**
     * Getting the stories carousel (followed users' stories).
     */
    suspend fun carousel(
    ): Response<Array<StoriesStoryResponse>>

    @JsExport.Ignore
    fun carouselBlocking(
    ): Response<Array<StoriesStoryResponse>>

    /**
     * Uploading media for a story (step 1 of 2).
     */
    suspend fun add(
        request: StoriesAddRequest
    ): Response<StoriesStoryResponse>

    @JsExport.Ignore
    fun addBlocking(
        request: StoriesAddRequest
    ): Response<StoriesStoryResponse>

    /**
     * Publishing an uploaded story (step 2 of 2).
     */
    suspend fun publish(
        request: StoriesPublishRequest
    ): Response<StoriesStoryResponse>

    @JsExport.Ignore
    fun publishBlocking(
        request: StoriesPublishRequest
    ): Response<StoriesStoryResponse>

    /**
     * Expiring (deleting) one of your own stories.
     */
    suspend fun selfExpire(
        request: StoriesSelfExpireRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun selfExpireBlocking(
        request: StoriesSelfExpireRequest
    ): ResponseUnit

    /**
     * Getting the viewers of a story.
     */
    suspend fun viewers(
        request: StoriesViewersRequest
    ): Response<Array<StoriesViewerResponse>>

    @JsExport.Ignore
    fun viewersBlocking(
        request: StoriesViewersRequest
    ): Response<Array<StoriesViewerResponse>>
}
