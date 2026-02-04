package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.AccountsResource
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
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class AccountsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    AccountsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun verifyCredentials(
    ): Response<AccountsVerifyCredentialsResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/verify_credentials")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun verifyCredentialsBlocking(
    ): Response<AccountsVerifyCredentialsResponse> {
        return toBlocking {
            verifyCredentials()
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun updateCredentials(
        request: AccountsUpdateCredentialsRequest
    ): Response<AccountsUpdateCredentialsResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/update_credentials")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .pwn("display_name", request.displayName)
                .pwn("note", request.note)
                .pwn("avatar", request.avatar)
                .pwn("header", request.header)
                .patch()
        }
    }

    override fun updateCredentialsBlocking(
        request: AccountsUpdateCredentialsRequest
    ): Response<AccountsUpdateCredentialsResponse> {
        return toBlocking {
            updateCredentials(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun account(
        request: AccountsAccountRequest
    ): Response<AccountsAccountResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun accountBlocking(
        request: AccountsAccountRequest
    ): Response<AccountsAccountResponse> {
        return toBlocking {
            account(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun followers(
        request: AccountsFollowersRequest
    ): Response<Array<AccountsFollowersResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/followers")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun followersBlocking(
        request: AccountsFollowersRequest
    ): Response<Array<AccountsFollowersResponse>> {
        return toBlocking {
            followers(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun following(
        request: AccountsFollowingRequest
    ): Response<Array<AccountsFollowingResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/following")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun followingBlocking(
        request: AccountsFollowingRequest
    ): Response<Array<AccountsFollowingResponse>> {
        return toBlocking {
            following(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun statuses(
        request: AccountsStatusesRequest
    ): Response<Array<AccountsStatusesResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/statuses")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())

                .qwn("only_media", request.onlyMedia)
                .qwn("pinned", request.onlyPinned)
                .qwn("exclude_replies", request.excludeReplies)
                .qwn("exclude_reblogs", request.excludeReblogs)
                .get()
        }
    }

    override fun statusesBlocking(
        request: AccountsStatusesRequest
    ): Response<Array<AccountsStatusesResponse>> {
        return toBlocking {
            statuses(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun follow(
        request: AccountsFollowRequest
    ): Response<AccountsFollowResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/follow")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun followBlocking(
        request: AccountsFollowRequest
    ): Response<AccountsFollowResponse> {
        return toBlocking {
            follow(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun unfollow(
        request: AccountsUnfollowRequest
    ): Response<AccountsUnfollowResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/unfollow")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unfollowBlocking(
        request: AccountsUnfollowRequest
    ): Response<AccountsUnfollowResponse> {
        return toBlocking {
            unfollow(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun block(
        request: AccountsBlockRequest
    ): Response<AccountsBlockResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/block")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun blockBlocking(
        request: AccountsBlockRequest
    ): Response<AccountsBlockResponse> {
        return toBlocking {
            block(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun unblock(
        request: AccountsUnblockRequest
    ): Response<AccountsUnblockResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/unblock")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unblockBlocking(
        request: AccountsUnblockRequest
    ): Response<AccountsUnblockResponse> {
        return toBlocking {
            unblock(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun mute(
        request: AccountsMuteRequest
    ): Response<AccountsMuteResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/mute")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun muteBlocking(
        request: AccountsMuteRequest
    ): Response<AccountsMuteResponse> {
        return toBlocking {
            mute(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun unmute(
        request: AccountsUnmuteRequest
    ): Response<AccountsUnmuteResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/unmute")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun unmuteBlocking(
        request: AccountsUnmuteRequest
    ): Response<AccountsUnmuteResponse> {
        return toBlocking {
            unmute(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun relationships(
        request: AccountsRelationshipsRequest
    ): Response<Array<AccountsRelationshipsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/relationships")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .qwns("id", request.ids)
                .get()
        }
    }

    override fun relationshipsBlocking(
        request: AccountsRelationshipsRequest
    ): Response<Array<AccountsRelationshipsResponse>> {
        return toBlocking {
            relationships(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun search(
        request: AccountsSearchRequest
    ): Response<Array<AccountsSearchResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/search")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .qwn("q", request.query)
                .qwn("limit", request.limit)
                .get()
        }
    }

    override fun searchBlocking(
        request: AccountsSearchRequest
    ): Response<Array<AccountsSearchResponse>> {
        return toBlocking {
            search(request)
        }
    }
}
