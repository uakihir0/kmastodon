package work.socialhub.kmastodon.api;

import mastodon4j.Range;
import mastodon4j.entity.Account;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface BlocksResource {

    /**
     * Fetching a user's blocks.
     *
     * @return an array of Accounts blocked by the authenticated user
     */
    public Response<Account[]> getBlocks();

    /**
     * Fetching a user's blocks.
     *
     * @param range
     * @return an array of Accounts blocked by the authenticated user
     */
    public Response<Account[]> getBlocks(Range range);
}
