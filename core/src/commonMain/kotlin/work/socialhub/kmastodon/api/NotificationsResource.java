package work.socialhub.kmastodon.api;

import mastodon4j.Range;
import mastodon4j.entity.Alert;
import mastodon4j.entity.Notification;
import mastodon4j.entity.Subscription;
import mastodon4j.entity.share.Response;

import java.util.List;

/**
 * @author hecateball
 */
public interface NotificationsResource {

    /**
     * Fetching a user's notifications.
     *
     * @return a list of Notifications for the authenticated user
     */
    public Response<Notification[]> getNotifications(
            Range range,
            List<String> types,
            List<String> excludeTypes,
            Long id);

    /**
     * Getting a single notification.
     *
     * @param id
     * @return the Notification
     */
    public Response<Notification> getNotification(String id);

    /**
     * Clearing notifications. Deletes all notifications from the Mastodon server for the authenticated user.
     */
    public Response<Void> clearNotifications();


    /**
     * Get current subscription.
     *
     * @return subscription info.
     */
    public Response<Subscription> getSubscription();

    /**
     * Subscribe to push notifications.
     * Register service worker endpoint.
     *
     * @return subscription info that registered.
     */
    public Response<Subscription> pushSubscription(
            String endpoint,
            String p256dh,
            String auth,
            Alert alert);

    /**
     * Change types of notifications
     *
     * @return subscription info.
     */
    public Response<Subscription> editSubscription(
            Alert alert);
}
