package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.BookmarksResource
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksGetBookmarksRequest
import work.socialhub.kmastodon.api.request.bookmarks.BookmarksUnbookmarkRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksGetBookmarksResponse
import work.socialhub.kmastodon.api.response.bookmarks.BookmarksUnbookmarkResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class BookmarksResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service), BookmarksResource {

    override suspend fun bookmarks(
        request: BookmarksGetBookmarksRequest
    ): Response<Array<BookmarksGetBookmarksResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/bookmarks")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
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

    override suspend fun unbookmark(
        request: BookmarksUnbookmarkRequest
    ): Response<BookmarksUnbookmarkResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/unbookmark")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unbookmarkBlocking(
        request: BookmarksUnbookmarkRequest
    ): Response<BookmarksUnbookmarkResponse> {
        return toBlocking {
            unbookmark(request)
        }
    }
}
