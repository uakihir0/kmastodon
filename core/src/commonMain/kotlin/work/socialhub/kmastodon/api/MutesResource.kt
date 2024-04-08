package work.socialhub.kmastodon.api

import mastodon4j.entity.Account
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface MutesResource {
    /**
     * Fetching a user's mutes.
     *
     * @return an array of Accounts muted by the authenticated user
     */
    val mutes: Response<Array<Account?>?>?
}
