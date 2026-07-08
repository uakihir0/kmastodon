package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Ignore
import kotlin.test.Test

class NodesTest : AbstractTest() {

    @Test
    @Ignore("Requires live host credentials (relative NodeInfo URLs are now resolved automatically)")
    fun testNodeInfo() = runTest {
        val response = mastodon().nodes()
            .nodeInfo()
        println("Node info software: ${response.data.software?.name} ${response.data.software?.version}")
    }
}
