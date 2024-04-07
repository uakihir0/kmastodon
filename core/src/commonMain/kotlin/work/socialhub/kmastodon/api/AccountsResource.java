package work.socialhub.kmastodon.api;

import mastodon4j.Range;
import mastodon4j.entity.Account;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Status;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface AccountsResource {

    /**
     * Getting the current user.
     *
     * @return the authenticated user's Account
     */
    public Response<Account> verifyCredentials();

    /**
     * Updating the current user.
     *
     * @param displayName the name to display in the user's profile
     * @param note        a new biography for the user
     * @param avatar      a base64 encoded image to display as the user's avatar (e.g.
     *                    data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUoAAADrCAYAAAA...)
     * @param header      a base64 encoded image to display as the user's header image (e.g.
     *                    data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUoAAADrCAYAAAA...)
     * @return the updated Account
     */
    public Response<Account> updateCredentials(String displayName, String note, String avatar, String header);

    /**
     * Fetching an account.
     *
     * @param id
     * @return an Account
     */
    public Response<Account> getAccount(String id);

    /**
     * Getting an account's followers.
     *
     * @param id
     * @return an array of Accounts
     */
    public Response<Account[]> getFollowers(String id);

    /**
     * Getting an account's followers.
     *
     * @param id
     * @param range
     * @return an array of Accounts
     */
    public Response<Account[]> getFollowers(String id, Range range);

    /**
     * Getting who account is following.
     *
     * @param id
     * @return an array of Accounts
     */
    public Response<Account[]> getFollowing(String id);

    /**
     * Getting who account is following.
     *
     * @param id
     * @param range
     * @return an array of Accounts
     */
    public Response<Account[]> getFollowing(String id, Range range);

    /**
     * Getting an account's statuses.
     *
     * @param id
     * @return an array of Statuses
     */
    public Response<Status[]> getStatuses(String id);

    /**
     * Getting an account's statuses.
     *
     * @param id
     * @param range
     * @return an array of Statuses
     */
    public Response<Status[]> getStatuses(String id, Range range);

    /**
     * Getting an account's statuses.
     *
     * @return an array of Statuses
     */
    public Response<Status[]> getStatuses(
            String id,
            boolean onlyPinned,
            boolean onlyMedia,
            boolean excluedeReplies,
            boolean excludeReblogs,
            Range range);

    /**
     * Following an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> follow(String id);

    /**
     * Unfollowing an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> unfollow(String id);

    /**
     * Blocking an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> block(String id);

    /**
     * Unblocking an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> unblock(String id);

    /**
     * Muting an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> mute(String id);

    /**
     * Unmuting an account.
     *
     * @param id
     * @return the target account's Relationship.
     */
    public Response<Relationship> unmute(String id);

    /**
     * Getting an account's relationships.
     *
     * @param id
     * @param ids
     * @return an array of Relationships of the current user to a list of given accounts.
     */
    public Response<Relationship[]> relationships(String id, String... ids);

    /**
     * Searching for accounts.
     *
     * @param query what to search for
     * @return an array of matching Accounts. Will lookup an account remotely if the search term is in the
     * username@domain format and not yet in the database.
     */
    public Response<Account[]> search(String query);

    /**
     * Searching for accounts.
     *
     * @param query what to search for
     * @param limit maximum number of matching accounts to return (default: 40)
     * @return an array of matching Accounts. Will lookup an account remotely if the search term is in the
     * username@domain format and not yet in the database.
     */
    public Response<Account[]> search(String query, long limit);
}
