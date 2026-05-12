package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksBlockDomainRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksGetDomainBlocksRequest
import work.socialhub.kmastodon.api.request.domainblocks.DomainBlocksUnblockDomainRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.domainblocks.DomainBlocksGetDomainBlocksResponse
import kotlin.js.JsExport

@JsExport
interface DomainBlocksResource {

    /**
     * Getting domain blocks.
     */
    suspend fun domainBlocks(
        request: DomainBlocksGetDomainBlocksRequest
    ): Response<Array<DomainBlocksGetDomainBlocksResponse>>

    @JsExport.Ignore
    fun domainBlocksBlocking(
        request: DomainBlocksGetDomainBlocksRequest
    ): Response<Array<DomainBlocksGetDomainBlocksResponse>>

    /**
     * Blocking a domain.
     */
    suspend fun blockDomain(
        request: DomainBlocksBlockDomainRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun blockDomainBlocking(
        request: DomainBlocksBlockDomainRequest
    ): ResponseUnit

    /**
     * Unblocking a domain.
     */
    suspend fun unblockDomain(
        request: DomainBlocksUnblockDomainRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun unblockDomainBlocking(
        request: DomainBlocksUnblockDomainRequest
    ): ResponseUnit
}
