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
import work.socialhub.kmpcommon.runBlocking

class FollowRequestsResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    FollowRequestsResource {

    // TODO: need to support: max_id, since_id, limit
    override fun followRequests(
    ): Response<Array<FollowRequestsFollowRequestsResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/follow_requests")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }

    override fun authorizeFollowRequest(
        request: FollowRequestsAuthorizeFollowRequestRequest
    ): ResponseUnit {
        return runBlocking {
            proceedUnit {
                HttpRequest()
                    .url("${uri}/api/v1/follow_requests/${request.id}/authorize")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun rejectFollowRequest(
        request: FollowRequestsRejectFollowRequestRequest
    ): ResponseUnit {
        return runBlocking {
            proceedUnit {
                HttpRequest()
                    .url("${uri}/api/v1/follow_requests/${request.id}/reject")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }
}
