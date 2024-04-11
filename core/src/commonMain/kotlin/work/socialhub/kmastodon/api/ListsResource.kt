package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.lists.ListsAddAccountsToListRequest
import work.socialhub.kmastodon.api.request.lists.ListsCreateListRequest
import work.socialhub.kmastodon.api.request.lists.ListsDeleteAccountsToListRequest
import work.socialhub.kmastodon.api.request.lists.ListsDeleteListRequest
import work.socialhub.kmastodon.api.request.lists.ListsListAccountsRequest
import work.socialhub.kmastodon.api.request.lists.ListsListRequest
import work.socialhub.kmastodon.api.request.lists.ListsListsRequest
import work.socialhub.kmastodon.api.request.lists.ListsUpdateListRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.lists.ListsCreateListResponse
import work.socialhub.kmastodon.api.response.lists.ListsListAccountsResponse
import work.socialhub.kmastodon.api.response.lists.ListsListResponse
import work.socialhub.kmastodon.api.response.lists.ListsListsResponse
import work.socialhub.kmastodon.api.response.lists.ListsUpdateListResponse
import kotlin.js.JsExport

@JsExport
interface ListsResource {

    /**
     * Fetching the user's lists that a given account is part of.
     */
    fun lists(
        request: ListsListsRequest
    ): Response<Array<ListsListsResponse>>

    /**
     * Fetching accounts that are in a given list.
     */
    fun listAccounts(
        request: ListsListAccountsRequest
    ): Response<Array<ListsListAccountsResponse>>

    /**
     * Fetching list.
     */
    fun list(
        request: ListsListRequest
    ): Response<ListsListResponse>

    /**
     * Create list.
     */
    fun createList(
        request: ListsCreateListRequest
    ): Response<ListsCreateListResponse>

    /**
     * Update list.
     */
    fun updateList(
        request: ListsUpdateListRequest
    ): Response<ListsUpdateListResponse>

    /**
     * Delete list.
     */
    fun deleteList(
        request: ListsDeleteListRequest
    ): ResponseUnit

    /**
     * Add account to list.
     */
    fun addAccountsToList(
        request: ListsAddAccountsToListRequest
    ): ResponseUnit

    /**
     * Delete account to list.
     */
    fun deleteAccountsToList(
        request: ListsDeleteAccountsToListRequest
    ): ResponseUnit
}
