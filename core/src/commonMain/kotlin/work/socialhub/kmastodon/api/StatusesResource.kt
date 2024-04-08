package work.socialhub.kmastodon.api

import mastodon4j.Range
import mastodon4j.entity.Account
import mastodon4j.entity.Card
import mastodon4j.entity.Context
import mastodon4j.entity.Status
import mastodon4j.entity.request.StatusUpdate
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface StatusesResource {
    /**
     * Fetching a status.
     *
     * @param id
     * @return a Status
     */
    fun getStatus(id: String?): Response<Status?>?

    /**
     * Getting status context.
     *
     * @param id
     * @return a Context
     */
    fun getContext(id: String?): Response<Context?>?

    /**
     * Getting a card associated with a status.
     *
     * @param id
     * @return a Card
     */
    fun getCard(id: String?): Response<Card?>?

    /**
     * Getting who reblogged a status.
     *
     * @param id
     * @return an array of Accounts
     */
    fun getRebloggedBy(id: String?, range: Range?): Response<Array<Account?>?>?

    /**
     * Getting who favourited a status.
     *
     * @param id
     * @return an array of Accounts
     */
    fun getFavouritedBy(id: String?, range: Range?): Response<Array<Account?>?>?


    /**
     * Posting a new status.
     *
     * @param status
     * @return the new Status.
     */
    fun postStatus(status: StatusUpdate?): Response<Status?>?

    /**
     * Deleting a status.
     *
     * @param id
     */
    fun deleteStatus(id: String?): Response<java.lang.Void?>?

    /**
     * Reblogging a status.
     *
     * @param id
     */
    fun reblog(id: String?): Response<Status?>?

    /**
     * Unreblogging a status.
     *
     * @param id
     */
    fun unreblog(id: String?): Response<Status?>?

    /**
     * Favouriting a status.
     *
     * @param id
     * @return
     */
    fun favourite(id: String?): Response<Status?>?

    /**
     * Unfavouriting a status.
     *
     * @param id
     * @return
     */
    fun unfavourite(id: String?): Response<Status?>?
}
