package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.FollowsResource
import work.socialhub.kmastodon.api.request.follows.FollowsRemoteFollowRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.follows.FollowsRemoteFollowResponse
import work.socialhub.kmastodon.util.Headers
import work.socialhub.kmastodon.util.MediaType

class FollowsResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    FollowsResource {

    override fun remoteFollow(
        request: FollowsRemoteFollowRequest
    ): Response<FollowsRemoteFollowResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/follow_requests")
            .header(Headers.AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .pwn("uri", request.uri)
            .post()
    }
}
