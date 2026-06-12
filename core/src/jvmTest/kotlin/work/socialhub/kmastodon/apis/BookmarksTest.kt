package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksBookmarkRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksUnbookmarkRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesDeleteStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class BookmarksTest : AbstractTest() {

    @Test
    fun testBookmarks() = runTest {
        val response = mastodon().bookmarks()
            .bookmarks(BookmarksGetBookmarksRequest())
        assertNotNull(response.data)
        println("Bookmarks count: ${response.data.size}")
    }

    @Test
    fun testBookmarkAndUnbookmark() = runTest {
        val created = mastodon().statuses().postStatus(
            StatusesPostStatusRequest().also {
                it.status = "Bookmark test from kmastodon BookmarksTest"
            }
        )
        assertNotNull(created.data.id)
        val statusId = created.data.id

        try {
            val bookmarked = mastodon().bookmarks().bookmark(
                BookmarksBookmarkRequest().also { it.id = statusId }
            )
            assertNotNull(bookmarked.data)
            assertTrue(bookmarked.data.isBookmarked)
            println("Bookmarked status: $statusId")

            val unbookmarked = mastodon().bookmarks().unbookmark(
                BookmarksUnbookmarkRequest().also { it.id = statusId }
            )
            assertNotNull(unbookmarked.data)
            println("Unbookmarked status: $statusId")
        } finally {
            mastodon().statuses().deleteStatus(
                StatusesDeleteStatusRequest().also { it.id = statusId }
            )
            println("Deleted status: $statusId")
        }
    }
}
