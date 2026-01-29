package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.MastodonException
import work.socialhub.kmastodon.api.NodesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.nodes.NodesNodeInfoResponse
import work.socialhub.kmastodon.entity.nodeinfo.NodeInfo
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class NodesResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    NodesResource {
    override suspend fun nodeInfo(
    ): Response<NodesNodeInfoResponse> {
        val response =
            proceed<NodeInfo> {
                HttpRequest()
                    .path("${uri}/.well-known/nodeinfo")
                    .accept(MediaType.JSON)
                    .get()
            }

        val link = response.data.links?.firstOrNull()?.href
            ?: throw MastodonException("no node info links.")

        return proceed<NodesNodeInfoResponse> {
            HttpRequest()
                .path(link)
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun nodeInfoBlocking(
    ): Response<NodesNodeInfoResponse> {
        return toBlocking {
            nodeInfo()
        }
    }
}
