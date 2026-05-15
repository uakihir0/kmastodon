package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.follows.FollowsRemoteFollowRequest
import kotlin.test.Ignore
import kotlin.test.Test

class FollowsTest : AbstractTest() {

    @Test
    @Ignore("Requires a valid remote account URI to follow")
    fun testRemoteFollow() = runTest {
        mastodon().follows().remoteFollow(
            FollowsRemoteFollowRequest().also {
                it.uri = "https://example.com/@user"
            }
        )
    }
}
