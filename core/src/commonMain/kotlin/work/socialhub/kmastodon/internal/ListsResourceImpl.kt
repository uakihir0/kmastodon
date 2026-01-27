package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.ListsResource
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
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class ListsResourceImpl(
    uri: String,
    accessToken: String,
) : AbstractAuthResourceImpl(uri, accessToken),
    ListsResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun lists(
        request: ListsListsRequest
    ): Response<Array<ListsListsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/accounts/${request.id}/lists")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun listsBlocking(
        request: ListsListsRequest
    ): Response<Array<ListsListsResponse>> {
        return toBlocking {
            lists(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun listAccounts(
        request: ListsListAccountsRequest
    ): Response<Array<ListsListAccountsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}/accounts")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .query("limit", request.limit ?: 40)
                .get()
        }
    }

    override fun listAccountsBlocking(
        request: ListsListAccountsRequest
    ): Response<Array<ListsListAccountsResponse>> {
        return toBlocking {
            listAccounts(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun list(
        request: ListsListRequest
    ): Response<ListsListResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun listBlocking(
        request: ListsListRequest
    ): Response<ListsListResponse> {
        return toBlocking {
            list(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun createList(
        request: ListsCreateListRequest
    ): Response<ListsCreateListResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/lists")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("title", request.title)
                .post()
        }
    }

    override fun createListBlocking(
        request: ListsCreateListRequest
    ): Response<ListsCreateListResponse> {
        return toBlocking {
            createList(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun updateList(
        request: ListsUpdateListRequest
    ): Response<ListsUpdateListResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("title", request.title)
                .put()
        }
    }

    override fun updateListBlocking(
        request: ListsUpdateListRequest
    ): Response<ListsUpdateListResponse> {
        return toBlocking {
            updateList(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun deleteList(
        request: ListsDeleteListRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .delete()
        }
    }

    override fun deleteListBlocking(
        request: ListsDeleteListRequest
    ): ResponseUnit {
        return toBlocking {
            deleteList(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun addAccountsToList(
        request: ListsAddAccountsToListRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}/accounts")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwns("accountIds", request.accountIds)
                .post()
        }
    }

    override fun addAccountsToListBlocking(
        request: ListsAddAccountsToListRequest
    ): ResponseUnit {
        return toBlocking {
            addAccountsToList(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun deleteAccountsToList(
        request: ListsDeleteAccountsToListRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/lists/${request.id}/accounts")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwns("accountIds", request.accountIds)
                .delete()
        }
    }

    override fun deleteAccountsToListBlocking(
        request: ListsDeleteAccountsToListRequest
    ): ResponseUnit {
        return toBlocking {
            deleteAccountsToList(request)
        }
    }
}
