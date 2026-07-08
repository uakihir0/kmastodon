package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.pleroma.PleromaQuotesRequest
import work.socialhub.kmastodon.api.request.pleroma.PleromaReadNotificationsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.pleroma.PleromaNotificationResponse
import work.socialhub.kmastodon.api.response.pleroma.PleromaQuoteResponse
import kotlin.js.JsExport

/**
 * Miscellaneous Pleroma-specific endpoints.
 * https://docs.pleroma.social/backend/development/API/pleroma_api/
 */
@JsExport
interface PleromaExtrasResource {

    /**
     * Marking a single notification read.
     * (POST /api/v1/pleroma/notifications/read with `id`)
     */
    suspend fun readNotification(
        request: PleromaReadNotificationsRequest
    ): Response<PleromaNotificationResponse>

    @JsExport.Ignore
    fun readNotificationBlocking(
        request: PleromaReadNotificationsRequest
    ): Response<PleromaNotificationResponse>

    /**
     * Marking all notifications up to and including maxId read.
     * (POST /api/v1/pleroma/notifications/read with `max_id`)
     */
    suspend fun readNotifications(
        request: PleromaReadNotificationsRequest
    ): Response<Array<PleromaNotificationResponse>>

    @JsExport.Ignore
    fun readNotificationsBlocking(
        request: PleromaReadNotificationsRequest
    ): Response<Array<PleromaNotificationResponse>>

    /**
     * Getting statuses that quote the given status.
     */
    suspend fun quotes(
        request: PleromaQuotesRequest
    ): Response<Array<PleromaQuoteResponse>>

    @JsExport.Ignore
    fun quotesBlocking(
        request: PleromaQuotesRequest
    ): Response<Array<PleromaQuoteResponse>>
}
