package work.socialhub.kmastodon.api;

import mastodon4j.entity.Account;
import mastodon4j.entity.List;
import mastodon4j.entity.share.Response;

/**
 * @author uakihir0
 */
public interface ListsResource {

    /**
     * Fetching a user's lists.
     *
     * @return an array of Lists created by the authenticated user
     */
    public Response<List[]> getLists();

    /**
     * Fetching the user's lists that a given account is part of.
     *
     * @param id the account's id
     * @return an array of Lists created by the target user
     */
    public Response<List[]> getLists(String id);

    /**
     * Fetching accounts that are in a given list.
     *
     * @param id    the target list's id
     * @param limit maximum number of results. (default: 40)
     * @return an array of Accounts that are in a specified list.
     */
    public Response<Account[]> getListAccounts(String id, Long limit);

    /**
     * Fetching list.
     *
     * @param id the target list's id
     * @return a specified list.
     */
    public Response<List> getList(String id);

    /**
     * Create list.
     *
     * @param title list name
     * @return created list
     */
    public Response<List> createList(String title);

    /**
     * Update list.
     *
     * @param id    the target list's id
     * @param title list name
     * @return updated list
     */
    public Response<List> updateList(String id, String title);

    /**
     * Delete list.
     *
     * @param id the target list's id
     */
    public void deleteList(String id);

    /**
     * Add account to list.
     *
     * @param id         the target list's id
     * @param accountIds account ids to add
     */
    public void addAccountsToList(String id, long[] accountIds);

    /**
     * Delete account to list.
     *
     * @param id         the target list's id
     * @param accountIds account ids to add
     */
    public void deleteAccountsToList(String id, long[] accountIds);
}
