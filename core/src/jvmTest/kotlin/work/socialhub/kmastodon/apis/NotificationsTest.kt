package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpNotifications
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationsRequest
import kotlin.test.Test

class NotificationsTest : AbstractTest(){

    @Test
    fun testNotifications() = runTest {
        val response = mastodon().notifications().notifications(
           NotificationsNotificationsRequest()
        )
        dumpNotifications(response.data)
    }
}
