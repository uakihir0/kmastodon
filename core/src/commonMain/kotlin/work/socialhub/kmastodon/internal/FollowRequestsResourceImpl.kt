package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.FollowRequestsResource
import work.socialhub.kmastodon.api.request.followrequests.FollowRequestsAuthorizeFollowRequestRequest
import work.socialhub.kmastodon.api.request.followrequests.FollowRequestsRejectFollowRequestRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.followrequests.FollowRequestsFollowRequestsResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class FollowRequestsResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    FollowRequestsResource {

    // TODO: need to support: max_id, since_id, limit
    override suspend fun followRequests(
    ): Response<Array<FollowRequestsFollowRequestsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/follow_requests")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun followRequestsBlocking(
    ): Response<Array<FollowRequestsFollowRequestsResponse>> {
        return toBlocking {
            followRequests()
        }
    }

    override suspend fun authorizeFollowRequest(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/follow_requests/${request.id}/authorize")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun authorizeFollowRequestBlocking(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit {
        return toBlocking {
            authorizeFollowRequest(request)
        }
    }

    override suspend fun rejectFollowRequest(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/follow_requests/${request.id}/reject")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun rejectFollowRequestBlocking(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit {
        return toBlocking {
            rejectFollowRequest(request)
        }
    }
}
