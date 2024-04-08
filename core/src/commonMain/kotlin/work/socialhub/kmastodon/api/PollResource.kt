package work.socialhub.kmastodon.api

import mastodon4j.entity.Poll
import mastodon4j.entity.share.Response

/**
 * @author uakihir0
 */
interface PollResource {
    /**
     * Vote on a poll.
     */
    fun votePoll(id: String?, choices: LongArray?): Response<Poll?>?
}
