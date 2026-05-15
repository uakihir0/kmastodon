package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class FollowRequestsTest : AbstractTest() {

    @Test
    fun testFollowRequests() = runTest {
        val response = mastodon().followRequests()
            .followRequests()
        assertNotNull(response.data)
        println("Follow requests count: ${response.data.size}")
    }
}
