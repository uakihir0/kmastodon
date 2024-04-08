package work.socialhub.kmastodon.internal

import mastodon4j.MastodonException
import mastodon4j.api.NodeResource
import mastodon4j.entity.Node
import mastodon4j.entity.NodeInfo
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

class _NodeResource internal constructor(private val uri: String) : NodeResource {
    val nodeInfo: Response<Node>
        get() {
            val nodeInfo: Response<NodeInfo> =
                proceed(NodeInfo::class.java) {
                    HttpRequestBuilder()
                        .target(this.uri)
                        .path("/.well-known/nodeinfo")
                        .request(HttpMediaType.APPLICATION_JSON)
                        .get()
                }

            val links: List<NodeInfo.Links> = nodeInfo.get().getLinks()
            if (links.isEmpty()) {
                throw MastodonException(
                    java.lang.IllegalStateException(
                        "no node info links."
                    )
                )
            }

            return proceed(Node::class.java) {
                HttpRequestBuilder()
                    .target(links[0].getHref())
                    .request(HttpMediaType.APPLICATION_JSON)
                    .get()
            }
        }
}
