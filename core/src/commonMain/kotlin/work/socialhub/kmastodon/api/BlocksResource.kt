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
    fun blocks(
        request: BlocksBlocksRequest
    ): Response<Array<BlocksBlocksResponse>>
}
