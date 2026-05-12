package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.bookmarks.BookmarksDeleteBookmarkRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksGetBookmarksResponse
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
     * Deleting a bookmark.
     */
    suspend fun deleteBookmark(
        request: BookmarksDeleteBookmarkRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteBookmarkBlocking(
        request: BookmarksDeleteBookmarkRequest
    ): ResponseUnit
}
