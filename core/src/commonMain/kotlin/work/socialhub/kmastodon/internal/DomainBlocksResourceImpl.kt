package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.DomainBlocksResource
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksBlockDomainRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksGetDomainBlocksRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksUnblockDomainRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.domainblocks.DomainBlocksGetDomainBlocksResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class DomainBlocksResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service), DomainBlocksResource {

    override suspend fun domainBlocks(
        request: DomainBlocksGetDomainBlocksRequest
    ): Response<Array<DomainBlocksGetDomainBlocksResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/domain_blocks")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
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
                .url("${uri}/api/v1/domain_blocks")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
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
                .url("${uri}/api/v1/domain_blocks")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("domain", request.domain)
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
