package work.socialhub.kmastodon.api

import mastodon4j.entity.Account
import mastodon4j.entity.share.Response

/**
 * @author uakihir0
 */
interface ListsResource {
    /**
     * Fetching a user's lists.
     *
     * @return an array of Lists created by the authenticated user
     */
    val lists: Response<Array<List?>?>?

    /**
     * Fetching the user's lists that a given account is part of.
     *
     * @param id the account's id
     * @return an array of Lists created by the target user
     */
    fun getLists(id: String?): Response<Array<List?>?>?

    /**
     * Fetching accounts that are in a given list.
     *
     * @param id    the target list's id
     * @param limit maximum number of results. (default: 40)
     * @return an array of Accounts that are in a specified list.
     */
    fun getListAccounts(id: String?, limit: Long?): Response<Array<Account?>?>?

    /**
     * Fetching list.
     *
     * @param id the target list's id
     * @return a specified list.
     */
    fun getList(id: String?): Response<List?>?

    /**
     * Create list.
     *
     * @param title list name
     * @return created list
     */
    fun createList(title: String?): Response<List?>?

    /**
     * Update list.
     *
     * @param id    the target list's id
     * @param title list name
     * @return updated list
     */
    fun updateList(id: String?, title: String?): Response<List?>?

    /**
     * Delete list.
     *
     * @param id the target list's id
     */
    fun deleteList(id: String?)

    /**
     * Add account to list.
     *
     * @param id         the target list's id
     * @param accountIds account ids to add
     */
    fun addAccountsToList(id: String?, accountIds: LongArray?)

    /**
     * Delete account to list.
     *
     * @param id         the target list's id
     * @param accountIds account ids to add
     */
    fun deleteAccountsToList(id: String?, accountIds: LongArray?)
}
