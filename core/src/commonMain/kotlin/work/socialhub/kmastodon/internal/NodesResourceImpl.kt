package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.MastodonException
import work.socialhub.kmastodon.api.NodesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.nodes.NodesNodeInfoResponse
import work.socialhub.kmastodon.entity.nodeinfo.NodeInfo
import work.socialhub.kmastodon.entity.nodeinfo.NodeInfoLinks
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

        val href = response.data.links
            ?.let { selectNodeInfoLink(it) }
            ?.href
            ?: throw MastodonException("no node info links.")

        // Some instances (e.g. mastodon.social) return a relative href.
        val link = resolveLink(href)

        return proceed<NodesNodeInfoResponse> {
            HttpRequest()
                .path(link)
                .accept(MediaType.JSON)
                .get()
        }
    }

    /**
     * Pick the NodeInfo document link with the highest schema version
     * (2.1 > 2.0 > 1.x). Falls back to the first available link.
     */
    private fun selectNodeInfoLink(
        links: Array<NodeInfoLinks>
    ): NodeInfoLinks? {
        return links
            .filter { it.href != null }
            .maxByOrNull { it.rel?.substringAfterLast("/") ?: "" }
            ?: links.firstOrNull()
    }

    /**
     * Resolve a possibly-relative NodeInfo href against the instance uri.
     */
    private fun resolveLink(href: String): String {
        if (href.startsWith("http://") || href.startsWith("https://")) {
            return href
        }
        val base = uri.trimEnd('/')
        return if (href.startsWith("/")) "$base$href" else "$base/$href"
    }

    override fun nodeInfoBlocking(
    ): Response<NodesNodeInfoResponse> {
        return toBlocking {
            nodeInfo()
        }
    }
}
