package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.follows.FollowsRemoteFollowRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.follows.FollowsRemoteFollowResponse
import kotlin.js.JsExport


@JsExport
interface FollowsResource {

    /**
     * Following a remote user.
     */
    fun remoteFollow(
        request: FollowsRemoteFollowRequest
    ): Response<FollowsRemoteFollowResponse>
}
