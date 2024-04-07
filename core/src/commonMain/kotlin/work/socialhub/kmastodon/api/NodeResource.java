package work.socialhub.kmastodon.api;

import mastodon4j.entity.Node;
import mastodon4j.entity.share.Response;

/**
 * @author uakihir0
 */
public interface NodeResource {

    /**
     * Getting node information.
     *
     * @return the node information. Does not require authentication
     */
    public Response<Node> getNodeInfo();
}
