package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.CollectionsResource
import work.socialhub.kmastodon.api.request.collections.CollectionsAccountRequest
import work.socialhub.kmastodon.api.request.collections.CollectionsCollectionRequest
import work.socialhub.kmastodon.api.request.collections.CollectionsStatusRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.collections.CollectionsCollectionResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class CollectionsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    CollectionsResource {

    override suspend fun accountCollections(
        request: CollectionsAccountRequest
    ): Response<Array<CollectionsCollectionResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/collections/accounts/${request.accountId}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun accountCollectionsBlocking(
        request: CollectionsAccountRequest
    ): Response<Array<CollectionsCollectionResponse>> {
        return toBlocking {
            accountCollections(request)
        }
    }

    override suspend fun collection(
        request: CollectionsCollectionRequest
    ): Response<CollectionsCollectionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/collections/view/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun collectionBlocking(
        request: CollectionsCollectionRequest
    ): Response<CollectionsCollectionResponse> {
        return toBlocking {
            collection(request)
        }
    }

    override suspend fun addStatus(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/collections/add")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("collection_id", request.collectionId)
                .pwn("post_id", request.postId)
                .post()
        }
    }

    override fun addStatusBlocking(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse> {
        return toBlocking {
            addStatus(request)
        }
    }

    override suspend fun removeStatus(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/collections/remove")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("collection_id", request.collectionId)
                .pwn("post_id", request.postId)
                .post()
        }
    }

    override fun removeStatusBlocking(
        request: CollectionsStatusRequest
    ): Response<CollectionsCollectionResponse> {
        return toBlocking {
            removeStatus(request)
        }
    }
}
