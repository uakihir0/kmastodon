package work.socialhub.kmastodon.api;

import mastodon4j.entity.Instance;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface InstancesResource {

    /**
     * Getting instance information.
     *
     * @return the current Instance. Does not require authentication
     */
    public Response<Instance> getInstance();
}
