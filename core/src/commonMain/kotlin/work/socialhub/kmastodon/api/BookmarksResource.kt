package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksUnbookmarkRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksGetBookmarksResponse
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksUnbookmarkResponse
import kotlin.js.JsExport

@JsExport
interface BookmarksResource {

    /**
     * Getting bookmarks.
     */
    suspend fun bookmarks(
        request: BookmarksGetBookmarksRequest
    ): Response<Array<BookmarksGetBookmarksResponse>>

    @JsExport.Ignore
    fun bookmarksBlocking(
        request: BookmarksGetBookmarksRequest
    ): Response<Array<BookmarksGetBookmarksResponse>>

    /**
     * Removing a bookmark.
     */
    suspend fun unbookmark(
        request: BookmarksUnbookmarkRequest
    ): Response<BookmarksUnbookmarkResponse>

    @JsExport.Ignore
    fun unbookmarkBlocking(
        request: BookmarksUnbookmarkRequest
    ): Response<BookmarksUnbookmarkResponse>
}
