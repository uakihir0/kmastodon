package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.blocks.BlocksBlocksRequest
import kotlin.test.Test

class BlocksTest : AbstractTest() {

    @Test
    fun testBlocks() = runTest {
        val response = mastodon().blocks()
            .blocks(BlocksBlocksRequest())
        println("Blocks count: ${response.data.size}")
    }
}
