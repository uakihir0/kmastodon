package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.polls.PollsVotePollRequest
import kotlin.test.Ignore
import kotlin.test.Test

class PollsTest : AbstractTest() {

    @Test
    @Ignore
    fun testVotePoll() = runTest {
        mastodon().polls().votePoll(
            PollsVotePollRequest().also {
                it.id = "REQUIRED_POLL_ID"
                it.choices = arrayOf(0)
            }
        )
    }
}
