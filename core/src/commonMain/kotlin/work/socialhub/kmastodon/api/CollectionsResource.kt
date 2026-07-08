package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.collections.CollectionsAccountRequest
import work.socialhub.kmastodon.api.request.collections.CollectionsCollectionRequest
import work.socialhub.kmastodon.api.request.collections.CollectionsStatusRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.collections.CollectionsCollectionResponse
import kotlin.js.JsExport

/**
 * Pixelfed collections.
 * https://github.com/pixelfed/pixelfed/blob/dev/routes/api.php
 */
@JsExport
interface CollectionsResource {

    /**
     * Getting the collections of an account.
     */
    suspend fun accountCollections(
        request: CollectionsAccountRequest
    ): Response<Array<CollectionsCollectionResponse>>

    @JsExport.Ignore
    fun accountCollectionsBlocking(
        request: CollectionsAccountRequest
    ): Response<Array<CollectionsCollectionResponse>>

    /**
     * Getting a single collection.
     */
    suspend fun collection(
        request: CollectionsCollectionRequest
    ): Response<CollectionsCollectionResponse>

    @JsExport.Ignore
    fun collectionBlocking(
        request: CollectionsCollectionRequest
    ): Response<CollectionsCollectionResponse>

    /**
     * Adding a status to a collection.
     */
    suspend fun addStatus(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse>

    @JsExport.Ignore
    fun addStatusBlocking(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse>

    /**
     * Removing a status from a collection.
     */
    suspend fun removeStatus(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse>

    @JsExport.Ignore
    fun removeStatusBlocking(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse>
}
