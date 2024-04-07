package work.socialhub.kmastodon.streaming;

import mastodon4j.entity.Notification;

/**
 *
 * @author hecateball
 */
public interface NotificationEventListener {

    default public void onNotification(Notification notification) {
    }
}
