package work.socialhub.kmastodon.api;

import mastodon4j.Range;
import mastodon4j.entity.Account;
import mastodon4j.entity.Card;
import mastodon4j.entity.Context;
import mastodon4j.entity.Status;
import mastodon4j.entity.request.StatusUpdate;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface StatusesResource {

    /**
     * Fetching a status.
     *
     * @param id
     * @return a Status
     */
    public Response<Status> getStatus(String id);

    /**
     * Getting status context.
     *
     * @param id
     * @return a Context
     */
    public Response<Context> getContext(String id);

    /**
     * Getting a card associated with a status.
     *
     * @param id
     * @return a Card
     */
    public Response<Card> getCard(String id);

    /**
     * Getting who reblogged a status.
     *
     * @param id
     * @return an array of Accounts
     */
    Response<Account[]> getRebloggedBy(String id, Range range);

    /**
     * Getting who favourited a status.
     *
     * @param id
     * @return an array of Accounts
     */
    Response<Account[]> getFavouritedBy(String id, Range range);


    /**
     * Posting a new status.
     *
     * @param status
     * @return the new Status.
     */
    public Response<Status> postStatus(StatusUpdate status);

    /**
     * Deleting a status.
     *
     * @param id
     */
    public Response<Void> deleteStatus(String id);

    /**
     * Reblogging a status.
     *
     * @param id
     */
    public Response<Status> reblog(String id);

    /**
     * Unreblogging a status.
     *
     * @param id
     */
    public Response<Status> unreblog(String id);

    /**
     * Favouriting a status.
     *
     * @param id
     * @return
     */
    public Response<Status> favourite(String id);

    /**
     * Unfavouriting a status.
     *
     * @param id
     * @return
     */
    public Response<Status> unfavourite(String id);
}
