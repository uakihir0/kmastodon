package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class NodesTest : AbstractTest() {

    @Test
    fun testNodeInfo() = runTest {
        val response = mastodon().nodes()
            .nodeInfo()
        assertNotNull(response.data)
        assertNotNull(response.data.software)
        println("Node info software: ${response.data.software?.name} ${response.data.software?.version}")
    }
}
