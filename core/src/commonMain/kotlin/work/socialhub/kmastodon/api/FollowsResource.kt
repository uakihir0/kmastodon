package work.socialhub.kmastodon.api

import mastodon4j.entity.Account
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface FollowsResource {
    /**
     * Following a remote user.
     *
     * @param uri username@domain of the person you want to follow
     * @return the local representation of the followed account, as an Account
     */
    fun remoteFollow(uri: String?): Response<Account?>?
}
