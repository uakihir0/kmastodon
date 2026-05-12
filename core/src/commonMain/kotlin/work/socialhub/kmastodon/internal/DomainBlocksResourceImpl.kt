package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.DomainBlocksResource
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksBlockDomainRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksGetDomainBlocksRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksUnblockDomainRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.domainblocks.DomainBlocksGetDomainBlocksResponse
import work.socialhub.kmastodon.util.toBlocking

class DomainBlocksResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> work.socialhub.kmastodon.domain.Service,
) : AbstractAuthResourceImpl(uri, accessToken, service), DomainBlocksResource {

    override suspend fun domainBlocks(
        request: DomainBlocksGetDomainBlocksRequest
    ): Response<Array<DomainBlocksGetDomainBlocksResponse>> {
        return proceed<Array<DomainBlocksGetDomainBlocksResponse>> {
            HttpRequest()
                .url("$uri/api/v1/domain_blocks")
                .header("Authorization", bearerToken())
                .pwn("limit", request.range?.limit)
                .pwn("since_id", request.range?.sinceId)
                .pwn("max_id", request.range?.maxId)
                .pwn("min_id", request.range?.minId)
                .pwn("page", request.page?.offset)
                .pwn("limit", request.page?.limit)
                .get()
        }
    }

    override fun domainBlocksBlocking(
        request: DomainBlocksGetDomainBlocksRequest
    ): Response<Array<DomainBlocksGetDomainBlocksResponse>> {
        return toBlocking {
            domainBlocks(request)
        }
    }

    override suspend fun blockDomain(
        request: DomainBlocksBlockDomainRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("$uri/api/v1/domain_blocks")
                .header("Authorization", bearerToken())
                .pwn("domain", request.domain)
                .post()
        }
    }

    override fun blockDomainBlocking(
        request: DomainBlocksBlockDomainRequest
    ): ResponseUnit {
        return toBlocking {
            blockDomain(request)
        }
    }

    override suspend fun unblockDomain(
        request: DomainBlocksUnblockDomainRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("$uri/api/v1/domain_blocks/${request.domain}")
                .header("Authorization", bearerToken())
                .delete()
        }
    }

    override fun unblockDomainBlocking(
        request: DomainBlocksUnblockDomainRequest
    ): ResponseUnit {
        return toBlocking {
            unblockDomain(request)
        }
    }
}
