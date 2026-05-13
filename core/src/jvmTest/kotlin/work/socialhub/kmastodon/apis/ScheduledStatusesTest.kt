package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.scheduledstatuses.ScheduledStatusesGetScheduledStatusesRequest
import kotlin.test.Test

class ScheduledStatusesTest : AbstractTest() {

    @Test
    fun testScheduledStatuses() = runTest {
        val response = mastodon().scheduledStatuses()
            .scheduledStatuses(ScheduledStatusesGetScheduledStatusesRequest())
        println("Scheduled statuses count: ${response.data.size}")
    }
}
