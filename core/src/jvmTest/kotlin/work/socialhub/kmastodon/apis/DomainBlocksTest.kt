package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksGetDomainBlocksRequest
import kotlin.test.Test
import kotlin.test.assertNotNull

class DomainBlocksTest : AbstractTest() {

    @Test
    fun testDomainBlocks() = runTest {
        val response = mastodon().domainBlocks()
            .domainBlocks(DomainBlocksGetDomainBlocksRequest())
        assertNotNull(response.data)
        println("Domain blocks count: ${response.data.size}")
    }
}
