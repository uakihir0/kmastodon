package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.timelines.TimelinesHomeTimelineRequest
import kotlin.test.Test

class StatusesTest : AbstractTest() {

    @Test
    fun testHomeTimeline() {
        val response = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())

        dumpStatuses(response.data)
    }
}