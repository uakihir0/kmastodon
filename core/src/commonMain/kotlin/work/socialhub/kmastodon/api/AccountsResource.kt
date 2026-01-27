package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.accounts.AccountsAccountRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsBlockRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsFollowRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsFollowersRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsFollowingRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsMuteRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsRelationshipsRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsSearchRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsStatusesRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsUnblockRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsUnfollowRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsUnmuteRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsUpdateCredentialsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.accounts.AccountsAccountResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsBlockResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsFollowResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsFollowersResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsFollowingResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsMuteResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsRelationshipsResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsSearchResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsStatusesResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsUnblockResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsUnfollowResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsUnmuteResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsUpdateCredentialsResponse
import work.socialhub.kmastodon.api.response.accounts.AccountsVerifyCredentialsResponse
import kotlin.js.JsExport

@JsExport
interface AccountsResource {

    /**
     * Getting the current user.
     */
    suspend fun verifyCredentials(
    ): Response<AccountsVerifyCredentialsResponse>

    @JsExport.Ignore
    fun verifyCredentialsBlocking(
    ): Response<AccountsVerifyCredentialsResponse>

    /**
     * Updating the current user.
     */
    suspend fun updateCredentials(
        request: AccountsUpdateCredentialsRequest
    ): Response<AccountsUpdateCredentialsResponse>

    @JsExport.Ignore
    fun updateCredentialsBlocking(
        request: AccountsUpdateCredentialsRequest
    ): Response<AccountsUpdateCredentialsResponse>

    /**
     * Fetching an account.
     */
    suspend fun account(
        request: AccountsAccountRequest
    ): Response<AccountsAccountResponse>

    @JsExport.Ignore
    fun accountBlocking(
        request: AccountsAccountRequest
    ): Response<AccountsAccountResponse>

    /**
     * Getting an account's followers.
     */
    suspend fun followers(
        request: AccountsFollowersRequest
    ): Response<Array<AccountsFollowersResponse>>

    @JsExport.Ignore
    fun followersBlocking(
        request: AccountsFollowersRequest
    ): Response<Array<AccountsFollowersResponse>>

    /**
     * Getting who account is following.
     */
    suspend fun following(
        request: AccountsFollowingRequest
    ): Response<Array<AccountsFollowingResponse>>

    @JsExport.Ignore
    fun followingBlocking(
        request: AccountsFollowingRequest
    ): Response<Array<AccountsFollowingResponse>>

    /**
     * Getting an account's statuses.
     */
    suspend fun statuses(
        request: AccountsStatusesRequest
    ): Response<Array<AccountsStatusesResponse>>

    @JsExport.Ignore
    fun statusesBlocking(
        request: AccountsStatusesRequest
    ): Response<Array<AccountsStatusesResponse>>

    /**
     * Following an account.
     */
    suspend fun follow(
        request: AccountsFollowRequest
    ): Response<AccountsFollowResponse>

    @JsExport.Ignore
    fun followBlocking(
        request: AccountsFollowRequest
    ): Response<AccountsFollowResponse>

    /**
     * Unfollowing an account.
     */
    suspend fun unfollow(
        request: AccountsUnfollowRequest
    ): Response<AccountsUnfollowResponse>

    @JsExport.Ignore
    fun unfollowBlocking(
        request: AccountsUnfollowRequest
    ): Response<AccountsUnfollowResponse>

    /**
     * Blocking an account.
     */
    suspend fun block(
        request: AccountsBlockRequest
    ): Response<AccountsBlockResponse>

    @JsExport.Ignore
    fun blockBlocking(
        request: AccountsBlockRequest
    ): Response<AccountsBlockResponse>

    /**
     * Unblocking an account.
     */
    suspend fun unblock(
        request: AccountsUnblockRequest
    ): Response<AccountsUnblockResponse>

    @JsExport.Ignore
    fun unblockBlocking(
        request: AccountsUnblockRequest
    ): Response<AccountsUnblockResponse>

    /**
     * Muting an account.
     */
    suspend fun mute(
        request: AccountsMuteRequest
    ): Response<AccountsMuteResponse>

    @JsExport.Ignore
    fun muteBlocking(
        request: AccountsMuteRequest
    ): Response<AccountsMuteResponse>

    /**
     * Unmuting an account.
     */
    suspend fun unmute(
        request: AccountsUnmuteRequest
    ): Response<AccountsUnmuteResponse>

    @JsExport.Ignore
    fun unmuteBlocking(
        request: AccountsUnmuteRequest
    ): Response<AccountsUnmuteResponse>

    /**
     * Getting an account's relationships.
     */
    suspend fun relationships(
        request: AccountsRelationshipsRequest
    ): Response<Array<AccountsRelationshipsResponse>>

    @JsExport.Ignore
    fun relationshipsBlocking(
        request: AccountsRelationshipsRequest
    ): Response<Array<AccountsRelationshipsResponse>>

    /**
     * Searching for accounts.
     */
    suspend fun search(
        request: AccountsSearchRequest
    ): Response<Array<AccountsSearchResponse>>

    @JsExport.Ignore
    fun searchBlocking(
        request: AccountsSearchRequest
    ): Response<Array<AccountsSearchResponse>>
}
