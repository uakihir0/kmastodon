package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.PollsResource
import work.socialhub.kmastodon.api.request.polls.PollsVotePollRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.polls.PollsVotePollResponse
import work.socialhub.kmastodon.util.Headers
import work.socialhub.kmastodon.util.MediaType

class PollsResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    PollsResource {

    override fun votePoll(
        request: PollsVotePollRequest
    ): Response<PollsVotePollResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/polls/${request.id}/votes")
            .header(Headers.AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)

            .pwns("choices", request.choices)
            .post()
    }
}
