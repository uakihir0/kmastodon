package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.ScheduledStatusesResource
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesGetScheduledStatusesRequest
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesPatchScheduledStatusRequest
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesScheduledStatusRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.scheduledstatuses.ScheduledStatusesGetScheduledStatusesResponse
import work.socialhub.kmastodon.util.toBlocking

class ScheduledStatusesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> work.socialhub.kmastodon.domain.Service,
) : AbstractAuthResourceImpl(uri, accessToken, service), ScheduledStatusesResource {

    override suspend fun scheduledStatuses(
        request: ScheduledStatusesGetScheduledStatusesRequest
    ): Response<Array<ScheduledStatusesGetScheduledStatusesResponse>> {
        return proceed<Array<ScheduledStatusesGetScheduledStatusesResponse>> {
            HttpRequest()
                .url("$uri/api/v1/scheduled_statuses")
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

    override fun scheduledStatusesBlocking(
        request: ScheduledStatusesGetScheduledStatusesRequest
    ): Response<Array<ScheduledStatusesGetScheduledStatusesResponse>> {
        return toBlocking {
            scheduledStatuses(request)
        }
    }

    override suspend fun scheduledStatus(
        request: ScheduledStatusesScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse> {
        return proceed<ScheduledStatusesGetScheduledStatusesResponse> {
            HttpRequest()
                .url("$uri/api/v1/scheduled_statuses/${request.id}")
                .header("Authorization", bearerToken())
                .get()
        }
    }

    override fun scheduledStatusBlocking(
        request: ScheduledStatusesScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse> {
        return toBlocking {
            scheduledStatus(request)
        }
    }

    override suspend fun patchScheduledStatus(
        request: ScheduledStatusesPatchScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse> {
        return proceed<ScheduledStatusesGetScheduledStatusesResponse> {
            HttpRequest()
                .url("$uri/api/v1/scheduled_statuses/${request.id}")
                .header("Authorization", bearerToken())
                .pwn("scheduled_at", request.scheduledAt)
                .patch()
        }
    }

    override fun patchScheduledStatusBlocking(
        request: ScheduledStatusesPatchScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse> {
        return toBlocking {
            patchScheduledStatus(request)
        }
    }

    override suspend fun deleteScheduledStatus(
        request: ScheduledStatusesScheduledStatusRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("$uri/api/v1/scheduled_statuses/${request.id}")
                .header("Authorization", bearerToken())
                .delete()
        }
    }

    override fun deleteScheduledStatusBlocking(
        request: ScheduledStatusesScheduledStatusRequest
    ): ResponseUnit {
        return toBlocking {
            deleteScheduledStatus(request)
        }
    }
}
