package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import kotlin.test.Test

class CreateNoteTest : AbstractTest() {

    @Test
    fun testCreateNote() = runTest {
        mastodon().statuses().postStatus(
            StatusesPostStatusRequest().also {
                it.status = "Post from kmastodon! for test." + "\n" +
                        "https://github.com/uakihir0/kmastodon"
            }
        )
    }
}
