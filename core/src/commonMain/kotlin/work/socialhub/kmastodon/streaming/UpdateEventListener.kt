package work.socialhub.kmastodon.streaming

import mastodon4j.entity.Status

/**
 *
 * @author hecateball
 */
interface UpdateEventListener {
    fun onUpdate(status: Status?) {
    }
}
