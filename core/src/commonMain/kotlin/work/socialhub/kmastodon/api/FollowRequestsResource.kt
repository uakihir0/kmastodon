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
    fun followRequests(
    ): Response<Array<FollowRequestsFollowRequestsResponse>>

    /**
     * Authorizing follow requests.
     */
    fun authorizeFollowRequest(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit

    /**
     * Rejecting follow requests.
     */
    fun rejectFollowRequest(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit
}
