package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.PleromaExtrasResource
import work.socialhub.kmastodon.api.request.pleroma.PleromaQuotesRequest
import work.socialhub.kmastodon.api.request.pleroma.PleromaReadNotificationsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.pleroma.PleromaNotificationResponse
import work.socialhub.kmastodon.api.response.pleroma.PleromaQuoteResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class PleromaExtrasResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    PleromaExtrasResource {

    override suspend fun readNotification(
        request: PleromaReadNotificationsRequest
    ): Response<PleromaNotificationResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/notifications/read")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("id", request.id)
                .post()
        }
    }

    override fun readNotificationBlocking(
        request: PleromaReadNotificationsRequest
    ): Response<PleromaNotificationResponse> {
        return toBlocking {
            readNotification(request)
        }
    }

    override suspend fun readNotifications(
        request: PleromaReadNotificationsRequest
    ): Response<Array<PleromaNotificationResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/notifications/read")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("max_id", request.maxId)
                .post()
        }
    }

    override fun readNotificationsBlocking(
        request: PleromaReadNotificationsRequest
    ): Response<Array<PleromaNotificationResponse>> {
        return toBlocking {
            readNotifications(request)
        }
    }

    override suspend fun quotes(
        request: PleromaQuotesRequest
    ): Response<Array<PleromaQuoteResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/statuses/${request.id}/quotes")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun quotesBlocking(
        request: PleromaQuotesRequest
    ): Response<Array<PleromaQuoteResponse>> {
        return toBlocking {
            quotes(request)
        }
    }
}
