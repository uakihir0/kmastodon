package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.polls.PollsVotePollRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.polls.PollsVotePollResponse
import kotlin.js.JsExport

@JsExport
interface PollsResource {

    /**
     * Vote on a poll.
     */
    fun votePoll(
        request: PollsVotePollRequest
    ): Response<PollsVotePollResponse>
}
