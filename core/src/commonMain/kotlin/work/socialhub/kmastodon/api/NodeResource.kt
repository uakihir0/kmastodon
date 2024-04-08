package work.socialhub.kmastodon.api

import mastodon4j.entity.Node
import mastodon4j.entity.share.Response

/**
 * @author uakihir0
 */
interface NodeResource {
    /**
     * Getting node information.
     *
     * @return the node information. Does not require authentication
     */
    val nodeInfo: Response<Node?>?
}
