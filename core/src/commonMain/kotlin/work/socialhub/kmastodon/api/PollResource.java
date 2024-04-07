package work.socialhub.kmastodon.api;

import mastodon4j.entity.Poll;
import mastodon4j.entity.share.Response;

/**
 * @author uakihir0
 */
public interface PollResource {

    /**
     * Vote on a poll.
     */
    public Response<Poll> votePoll(String id, long[] choices);
}
