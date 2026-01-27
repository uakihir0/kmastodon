package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.StatusesResource
import work.socialhub.kmastodon.api.request.statuses.StatusesCardRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesContextRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesDeleteStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouritedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesReblogRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesRebloggedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnfavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnreblogRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.statuses.StatusesCardResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesContextResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesFavouriteResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesFavouritedByResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesPostStatusResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesReblogResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesRebloggedByResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesStatusResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesUnfavouriteResponse
import work.socialhub.kmastodon.api.response.statuses.StatusesUnreblogResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class StatusesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    StatusesResource {

    override suspend fun status(
        request: StatusesStatusRequest
    ): Response<StatusesStatusResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun statusBlocking(
        request: StatusesStatusRequest
    ): Response<StatusesStatusResponse> {
        return toBlocking {
            status(request)
        }
    }

    override suspend fun context(
        request: StatusesContextRequest
    ): Response<StatusesContextResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/context")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun contextBlocking(
        request: StatusesContextRequest
    ): Response<StatusesContextResponse> {
        return toBlocking {
            context(request)
        }
    }

    override suspend fun card(
        request: StatusesCardRequest
    ): Response<StatusesCardResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/card")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun cardBlocking(
        request: StatusesCardRequest
    ): Response<StatusesCardResponse> {
        return toBlocking {
            card(request)
        }
    }

    override suspend fun rebloggedBy(
        request: StatusesRebloggedByRequest
    ): Response<Array<StatusesRebloggedByResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/reblogged_by")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun rebloggedByBlocking(
        request: StatusesRebloggedByRequest
    ): Response<Array<StatusesRebloggedByResponse>> {
        return toBlocking {
            rebloggedBy(request)
        }
    }

    override suspend fun favouritedBy(
        request: StatusesFavouritedByRequest
    ): Response<Array<StatusesFavouritedByResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/favourited_by")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun favouritedByBlocking(
        request: StatusesFavouritedByRequest
    ): Response<Array<StatusesFavouritedByResponse>> {
        return toBlocking {
            favouritedBy(request)
        }
    }

    override suspend fun postStatus(
        request: StatusesPostStatusRequest
    ): Response<StatusesPostStatusResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .pwn("status", request.status)
                .pwn("in_reply_to_id", request.inReplyToId)
                .pwn("sensitive", request.sensitive)
                .pwn("spoiler_text", request.spoilerText)
                .pwn("visibility", request.visibility)
                .pwns("media_ids", request.mediaIds)

                .pwns("poll[options]", request.pollOptions)
                .pwn("poll[expires_in]", request.pollExpiresIn)
                .pwn("poll[multiple]", request.pollMultiple)
                .pwn("poll[hide_totals]", request.pollHideTotals)
                .post()
        }
    }

    override fun postStatusBlocking(
        request: StatusesPostStatusRequest
    ): Response<StatusesPostStatusResponse> {
        return toBlocking {
            postStatus(request)
        }
    }

    override suspend fun deleteStatus(
        request: StatusesDeleteStatusRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .delete()
        }
    }

    override fun deleteStatusBlocking(
        request: StatusesDeleteStatusRequest
    ): ResponseUnit {
        return toBlocking {
            deleteStatus(request)
        }
    }

    override suspend fun reblog(
        request: StatusesReblogRequest
    ): Response<StatusesReblogResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/reblog")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun reblogBlocking(
        request: StatusesReblogRequest
    ): Response<StatusesReblogResponse> {
        return toBlocking {
            reblog(request)
        }
    }

    override suspend fun unreblog(
        request: StatusesUnreblogRequest
    ): Response<StatusesUnreblogResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/unreblog")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unreblogBlocking(
        request: StatusesUnreblogRequest
    ): Response<StatusesUnreblogResponse> {
        return toBlocking {
            unreblog(request)
        }
    }

    override suspend fun favourite(
        request: StatusesFavouriteRequest
    ): Response<StatusesFavouriteResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/favourite")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun favouriteBlocking(
        request: StatusesFavouriteRequest
    ): Response<StatusesFavouriteResponse> {
        return toBlocking {
            favourite(request)
        }
    }

    override suspend fun unfavourite(
        request: StatusesUnfavouriteRequest
    ): Response<StatusesUnfavouriteResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/statuses/${request.id}/unfavourite")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unfavouriteBlocking(
        request: StatusesUnfavouriteRequest
    ): Response<StatusesUnfavouriteResponse> {
        return toBlocking {
            unfavourite(request)
        }
    }
}
