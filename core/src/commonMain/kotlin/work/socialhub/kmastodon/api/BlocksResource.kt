package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.blocks.BlocksBlocksRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.blocks.BlocksBlocksResponse
import kotlin.js.JsExport


@JsExport
interface BlocksResource {

    /**
     * Fetching a user's blocks.
     */
    suspend fun blocks(
        request: BlocksBlocksRequest
    ): Response<Array<BlocksBlocksResponse>>

    @JsExport.Ignore
    fun blocksBlocking(
        request: BlocksBlocksRequest
    ): Response<Array<BlocksBlocksResponse>>
}
