package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpNotifications
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationsRequest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertNotNull

class NotificationsTest : AbstractTest() {

    @Test
    fun testNotifications() = runTest {
        val response = mastodon().notifications().notifications(
            NotificationsNotificationsRequest()
        )
        assertNotNull(response.data)
        dumpNotifications(response.data)
    }

    @Test
    @Ignore("Requires existing notifications on the test account")
    fun testNotification() = runTest {
        val notifications = mastodon().notifications().notifications(
            NotificationsNotificationsRequest()
        )
        val firstId = notifications.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().notifications().notification(
            NotificationsNotificationRequest().also { it.id = firstId }
        )
        assertNotNull(response.data.type)
        println("Notification type: ${response.data.type}")
    }

    @Test
    @Ignore("Requires a push subscription to be set up on the test account")
    fun testSubscription() = runTest {
        val response = mastodon().notifications().subscription()
        assertNotNull(response.data.endpoint)
        println("Subscription endpoint: ${response.data.endpoint}")
    }
}
