package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpNotifications
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationsRequest
import kotlin.test.Ignore
import kotlin.test.Test

class NotificationsTest : AbstractTest() {

    @Test
    fun testNotifications() = runTest {
        val response = mastodon().notifications().notifications(
            NotificationsNotificationsRequest()
        )
        dumpNotifications(response.data)
    }

    @Test
    @Ignore
    fun testNotification() = runTest {
        val notifications = mastodon().notifications().notifications(
            NotificationsNotificationsRequest()
        )
        val firstId = notifications.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().notifications().notification(
            NotificationsNotificationRequest().also { it.id = firstId }
        )
        println("Notification type: ${response.data.type}")
    }

    @Test
    @Ignore
    fun testSubscription() = runTest {
        val response = mastodon().notifications().subscription()
        println("Subscription endpoint: ${response.data.endpoint}")
    }
}
