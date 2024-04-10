package work.socialhub.kmastodon.stream.listener

import work.socialhub.kmastodon.entity.Notification

interface NotificationEventListener {
    fun onNotification(notification: Notification)
}
