package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test

class FollowRequestsTest : AbstractTest() {

    @Test
    fun testFollowRequests() = runTest {
        val response = mastodon().followRequests()
            .followRequests()
        println("Follow requests count: ${response.data.size}")
    }
}
