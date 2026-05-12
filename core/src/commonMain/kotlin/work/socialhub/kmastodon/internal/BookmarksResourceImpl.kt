package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.BookmarksResource
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksDeleteBookmarkRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksGetBookmarksResponse
import work.socialhub.kmastodon.util.toBlocking

class BookmarksResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> work.socialhub.kmastodon.domain.Service,
) : AbstractAuthResourceImpl(uri, accessToken, service), BookmarksResource {

    override suspend fun bookmarks(
        request: BookmarksGetBookmarksRequest
    ): Response<Array<BookmarksGetBookmarksResponse>> {
        return proceed<Array<BookmarksGetBookmarksResponse>> {
            HttpRequest()
                .url("$uri/api/v1/bookmarks")
                .header("Authorization", bearerToken())
                .pwn("limit", request.range?.limit)
                .pwn("since_id", request.range?.sinceId)
                .pwn("max_id", request.range?.maxId)
                .pwn("min_id", request.range?.minId)
                .pwn("page", request.page?.offset)
                .pwn("limit", request.page?.limit)
                .get()
        }
    }

    override fun bookmarksBlocking(
        request: BookmarksGetBookmarksRequest
    ): Response<Array<BookmarksGetBookmarksResponse>> {
        return toBlocking {
            bookmarks(request)
        }
    }

    override suspend fun deleteBookmark(
        request: BookmarksDeleteBookmarkRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("$uri/api/v1/bookmarks/${request.id}")
                .header("Authorization", bearerToken())
                .delete()
        }
    }

    override fun deleteBookmarkBlocking(
        request: BookmarksDeleteBookmarkRequest
    ): ResponseUnit {
        return toBlocking {
            deleteBookmark(request)
        }
    }
}
