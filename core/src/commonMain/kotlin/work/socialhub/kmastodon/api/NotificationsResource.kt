package work.socialhub.kmastodon.api

import mastodon4j.Range
import mastodon4j.entity.Alert
import mastodon4j.entity.Notification
import mastodon4j.entity.Subscription
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface NotificationsResource {
    /**
     * Fetching a user's notifications.
     *
     * @return a list of Notifications for the authenticated user
     */
    fun getNotifications(
        range: Range?,
        types: List<String?>?,
        excludeTypes: List<String?>?,
        id: Long?
    ): Response<Array<Notification?>?>?

    /**
     * Getting a single notification.
     *
     * @param id
     * @return the Notification
     */
    fun getNotification(id: String?): Response<Notification?>?

    /**
     * Clearing notifications. Deletes all notifications from the Mastodon server for the authenticated user.
     */
    fun clearNotifications(): Response<java.lang.Void?>?


    /**
     * Get current subscription.
     *
     * @return subscription info.
     */
    val subscription: Response<Subscription?>?

    /**
     * Subscribe to push notifications.
     * Register service worker endpoint.
     *
     * @return subscription info that registered.
     */
    fun pushSubscription(
        endpoint: String?,
        p256dh: String?,
        auth: String?,
        alert: Alert?
    ): Response<Subscription?>?

    /**
     * Change types of notifications
     *
     * @return subscription info.
     */
    fun editSubscription(
        alert: Alert?
    ): Response<Subscription?>?
}
