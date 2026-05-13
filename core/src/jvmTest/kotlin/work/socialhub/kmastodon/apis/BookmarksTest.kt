package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksUnbookmarkRequest
import kotlin.test.Ignore
import kotlin.test.Test

class BookmarksTest : AbstractTest() {

    @Test
    fun testBookmarks() = runTest {
        val response = mastodon().bookmarks()
            .bookmarks(BookmarksGetBookmarksRequest())
        println("Bookmarks count: ${response.data.size}")
    }

    @Test
    @Ignore
    fun testUnbookmark() = runTest {
        mastodon().bookmarks().unbookmark(
            BookmarksUnbookmarkRequest().also {
                it.id = "REQUIRED_STATUS_ID"
            }
        )
    }
}
