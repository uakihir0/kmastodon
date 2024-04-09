package work.socialhub.kmastodon.internal

import mastodon4j.entity.Account
import mastodon4j.entity.Relationship
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder
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
import work.socialhub.kmpcommon.runBlocking

/**
 * @author hecateball
 */
class AccountsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractResourceImpl(uri, accessToken, service),
    AccountsResource {

    /**
     * {@inheritDoc}
     */
    override fun verifyCredentials(
    ): Response<AccountsVerifyCredentialsResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/verify_credentials")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun updateCredentials(
        request: AccountsUpdateCredentialsRequest
    ): Response<AccountsUpdateCredentialsResponse> {
        return runBlocking {
            proceed {
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
    }

    /**
     * {@inheritDoc}
     */
    override fun account(
        request: AccountsAccountRequest
    ): Response<AccountsAccountResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun followers(
        request: AccountsFollowersRequest
    ): Response<Array<AccountsFollowersResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/followers")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .paging(request.range, service())
                    .get()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun following(
        request: AccountsFollowingRequest
    ): Response<Array<AccountsFollowingResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/following")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .paging(request.range, service())
                    .get()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun statuses(
        request: AccountsStatusesRequest
    ): Response<Array<AccountsStatusesResponse>> {
        return runBlocking {
            proceed {
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
    }

    /**
     * {@inheritDoc}
     */
    override fun follow(
        request: AccountsFollowRequest
    ): Response<AccountsFollowResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/follow")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun unfollow(
        request: AccountsUnfollowRequest
    ): Response<AccountsUnfollowResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/unfollow")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun block(
        request: AccountsBlockRequest
    ): Response<AccountsBlockResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/block")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun unblock(
        request: AccountsUnblockRequest
    ): Response<AccountsUnblockResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/unblock")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun mute(
        request: AccountsMuteRequest
    ): Response<AccountsMuteResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/mute")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun unmute(
        request: AccountsUnmuteRequest
    ): Response<AccountsUnmuteResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/${request.id}/unmute")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun relationships(
        request: AccountsRelationshipsRequest
    ): Response<Array<AccountsRelationshipsResponse>> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/accounts/relationships")
                    .header(AUTHORIZATION, bearerToken())
                    .accept(MediaType.JSON)
                    .qwns("id", request.ids)
                    .get()
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun search(request: AccountsSearchRequest): Response<Array<AccountsSearchResponse>> {
        TODO("Not yet implemented")
    }


    /**
     * {@inheritDoc}
     */
    fun relationships(id: String?, vararg ids: String?): Response<Array<Relationship>> {

    }

    fun search(query: String?): Response<Array<Account>> {
        return this.search(query, DEFAULT_LIMIT)
    }

    /**
     * {@inheritDoc}
     */
    fun search(query: String?, limit: Long): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/search")
                .param("q", query)
                .param("limit", limit)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    companion object {
        private const val DEFAULT_LIMIT: Long = 40
    }
}
