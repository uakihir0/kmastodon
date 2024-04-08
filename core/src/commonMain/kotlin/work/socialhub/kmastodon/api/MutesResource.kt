package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.mutes.MutesMutesResponse

interface MutesResource {

    /**
     * Fetching a user's mutes.
     */
    fun mutes(
    ): Response<Array<MutesMutesResponse>>
}
