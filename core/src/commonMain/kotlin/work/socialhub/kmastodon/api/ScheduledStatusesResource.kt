package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesGetScheduledStatusesRequest
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesPatchScheduledStatusRequest
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesScheduledStatusRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.scheduledstatuses.ScheduledStatusesGetScheduledStatusesResponse
import kotlin.js.JsExport

@JsExport
interface ScheduledStatusesResource {

    /**
     * Getting scheduled statuses.
     */
    suspend fun scheduledStatuses(
        request: ScheduledStatusesGetScheduledStatusesRequest
    ): Response<Array<ScheduledStatusesGetScheduledStatusesResponse>>

    @JsExport.Ignore
    fun scheduledStatusesBlocking(
        request: ScheduledStatusesGetScheduledStatusesRequest
    ): Response<Array<ScheduledStatusesGetScheduledStatusesResponse>>

    /**
     * Getting a single scheduled status.
     */
    suspend fun scheduledStatus(
        request: ScheduledStatusesScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse>

    @JsExport.Ignore
    fun scheduledStatusBlocking(
        request: ScheduledStatusesScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse>

    /**
     * Updating a single scheduled status.
     */
    suspend fun patchScheduledStatus(
        request: ScheduledStatusesPatchScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse>

    @JsExport.Ignore
    fun patchScheduledStatusBlocking(
        request: ScheduledStatusesPatchScheduledStatusRequest
    ): Response<ScheduledStatusesGetScheduledStatusesResponse>

    /**
     * Deleting a scheduled status.
     */
    suspend fun deleteScheduledStatus(
        request: ScheduledStatusesScheduledStatusRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteScheduledStatusBlocking(
        request: ScheduledStatusesScheduledStatusRequest
    ): ResponseUnit
}
