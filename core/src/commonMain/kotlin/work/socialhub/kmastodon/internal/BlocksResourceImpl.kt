package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.BlocksResource
import work.socialhub.kmastodon.api.request.blocks.BlocksBlocksRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.blocks.BlocksBlocksResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmpcommon.runBlocking

class BlocksResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    BlocksResource {

    override fun blocks(
        request: BlocksBlocksRequest
    ): Response<Array<BlocksBlocksResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/blocks")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .paging(request.range, service())
                    .get()
            }
        }
    }
}
