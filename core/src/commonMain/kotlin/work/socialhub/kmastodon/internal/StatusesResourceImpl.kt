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

class StatusesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    StatusesResource {

    override fun status(
        request: StatusesStatusRequest
    ): Response<StatusesStatusResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .get()
    }

    override fun context(
        request: StatusesContextRequest
    ): Response<StatusesContextResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/context")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .get()
    }

    override fun card(
        request: StatusesCardRequest
    ): Response<StatusesCardResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/card")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .get()
    }

    override fun rebloggedBy(
        request: StatusesRebloggedByRequest
    ): Response<Array<StatusesRebloggedByResponse>> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/reblogged_by")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .paging(request.range, service())
            .get()
    }

    override fun favouritedBy(
        request: StatusesFavouritedByRequest
    ): Response<Array<StatusesFavouritedByResponse>> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/favourited_by")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .paging(request.range, service())
            .get()
    }

    override fun postStatus(
        request: StatusesPostStatusRequest
    ): Response<StatusesPostStatusResponse> = exec {
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

    override fun deleteStatus(
        request: StatusesDeleteStatusRequest
    ): ResponseUnit = unit {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .delete()
    }

    override fun reblog(
        request: StatusesReblogRequest
    ): Response<StatusesReblogResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/reblog")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .post()
    }

    override fun unreblog(
        request: StatusesUnreblogRequest
    ): Response<StatusesUnreblogResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/unreblog")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .post()
    }

    override fun favourite(
        request: StatusesFavouriteRequest
    ): Response<StatusesFavouriteResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/favourite")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .post()
    }

    override fun unfavourite(
        request: StatusesUnfavouriteRequest
    ): Response<StatusesUnfavouriteResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/statuses/${request.id}/unfavourite")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .post()
    }
}
