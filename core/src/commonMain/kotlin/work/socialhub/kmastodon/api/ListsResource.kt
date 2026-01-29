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
    suspend fun lists(
        request: ListsListsRequest
    ): Response<Array<ListsListsResponse>>

    @JsExport.Ignore
    fun listsBlocking(
        request: ListsListsRequest
    ): Response<Array<ListsListsResponse>>

    /**
     * Fetching accounts that are in a given list.
     */
    suspend fun listAccounts(
        request: ListsListAccountsRequest
    ): Response<Array<ListsListAccountsResponse>>

    @JsExport.Ignore
    fun listAccountsBlocking(
        request: ListsListAccountsRequest
    ): Response<Array<ListsListAccountsResponse>>

    /**
     * Fetching list.
     */
    suspend fun list(
        request: ListsListRequest
    ): Response<ListsListResponse>

    @JsExport.Ignore
    fun listBlocking(
        request: ListsListRequest
    ): Response<ListsListResponse>

    /**
     * Create list.
     */
    suspend fun createList(
        request: ListsCreateListRequest
    ): Response<ListsCreateListResponse>

    @JsExport.Ignore
    fun createListBlocking(
        request: ListsCreateListRequest
    ): Response<ListsCreateListResponse>

    /**
     * Update list.
     */
    suspend fun updateList(
        request: ListsUpdateListRequest
    ): Response<ListsUpdateListResponse>

    @JsExport.Ignore
    fun updateListBlocking(
        request: ListsUpdateListRequest
    ): Response<ListsUpdateListResponse>

    /**
     * Delete list.
     */
    suspend fun deleteList(
        request: ListsDeleteListRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteListBlocking(
        request: ListsDeleteListRequest
    ): ResponseUnit

    /**
     * Add account to list.
     */
    suspend fun addAccountsToList(
        request: ListsAddAccountsToListRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun addAccountsToListBlocking(
        request: ListsAddAccountsToListRequest
    ): ResponseUnit

    /**
     * Delete account to list.
     */
    suspend fun deleteAccountsToList(
        request: ListsDeleteAccountsToListRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteAccountsToListBlocking(
        request: ListsDeleteAccountsToListRequest
    ): ResponseUnit
}
