package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.notifications.NotificationsEditSubscriptionRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationsRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsPostSubscriptionRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.notifications.NotificationsEditSubscriptionResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsNotificationResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsNotificationsResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsPostSubscriptionResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsSubscriptionResponse
import kotlin.js.JsExport

@JsExport
interface NotificationsResource {

    /**
     * Fetching a user's notifications.
     */
    suspend fun notifications(
        request: NotificationsNotificationsRequest
    ): Response<Array<NotificationsNotificationsResponse>>

    @JsExport.Ignore
    fun notificationsBlocking(
        request: NotificationsNotificationsRequest
    ): Response<Array<NotificationsNotificationsResponse>>

    /**
     * Getting a single notification.
     */
    suspend fun notification(
        request: NotificationsNotificationRequest
    ): Response<NotificationsNotificationResponse>

    @JsExport.Ignore
    fun notificationBlocking(
        request: NotificationsNotificationRequest
    ): Response<NotificationsNotificationResponse>

    /**
     * Clearing notifications. Deletes all notifications
     * from the Mastodon server for the authenticated user.
     */
    suspend fun clearNotifications(
    ): ResponseUnit

    @JsExport.Ignore
    fun clearNotificationsBlocking(
    ): ResponseUnit

    /**
     * Get current subscription.
     */
    suspend fun subscription(
    ): Response<NotificationsSubscriptionResponse>

    @JsExport.Ignore
    fun subscriptionBlocking(
    ): Response<NotificationsSubscriptionResponse>

    /**
     * Subscribe to push notifications.
     * Register service worker endpoint.
     */
    suspend fun pushSubscription(
        request: NotificationsPostSubscriptionRequest
    ): Response<NotificationsPostSubscriptionResponse>

    @JsExport.Ignore
    fun pushSubscriptionBlocking(
        request: NotificationsPostSubscriptionRequest
    ): Response<NotificationsPostSubscriptionResponse>

    /**
     * Change types of notifications
     */
    suspend fun editSubscription(
        request: NotificationsEditSubscriptionRequest
    ): Response<NotificationsEditSubscriptionResponse>

    @JsExport.Ignore
    fun editSubscriptionBlocking(
        request: NotificationsEditSubscriptionRequest
    ): Response<NotificationsEditSubscriptionResponse>
}
