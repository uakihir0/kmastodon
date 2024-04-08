package work.socialhub.kmastodon.streaming

import mastodon4j.entity.Notification

/**
 *
 * @author hecateball
 */
interface NotificationEventListener {
    fun onNotification(notification: Notification?) {
    }
}
