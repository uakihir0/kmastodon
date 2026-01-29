package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.followrequests.FollowRequestsAuthorizeFollowRequestRequest
import work.socialhub.kmastodon.api.request.followrequests.FollowRequestsRejectFollowRequestRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.followrequests.FollowRequestsFollowRequestsResponse
import kotlin.js.JsExport

@JsExport
interface FollowRequestsResource {

    /**
     * Fetching a list of follow requests.
     */
    suspend fun followRequests(
    ): Response<Array<FollowRequestsFollowRequestsResponse>>

    @JsExport.Ignore
    fun followRequestsBlocking(
    ): Response<Array<FollowRequestsFollowRequestsResponse>>

    /**
     * Authorizing follow requests.
     */
    suspend fun authorizeFollowRequest(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun authorizeFollowRequestBlocking(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit

    /**
     * Rejecting follow requests.
     */
    suspend fun rejectFollowRequest(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun rejectFollowRequestBlocking(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit
}
