package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.statuses.StatusesDeleteStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import kotlin.test.Test
import kotlin.test.assertNotNull

class CreateNoteTest : AbstractTest() {

    @Test
    fun testCreateNote() = runTest {
        val created = mastodon().statuses().postStatus(
            StatusesPostStatusRequest().also {
                it.status = "Post from kmastodon! for test." + "\n" +
                        "https://github.com/uakihir0/kmastodon"
            }
        )
        assertNotNull(created.data.id)
        try {
            println("Created status: ${created.data.id}")
        } finally {
            mastodon().statuses().deleteStatus(
                StatusesDeleteStatusRequest().also { it.id = created.data.id }
            )
        }
    }
}
