package work.socialhub.kmastodon.api

import mastodon4j.entity.Instance
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface InstancesResource {
    /**
     * Getting instance information.
     *
     * @return the current Instance. Does not require authentication
     */
    val instance: Response<Instance?>?
}
