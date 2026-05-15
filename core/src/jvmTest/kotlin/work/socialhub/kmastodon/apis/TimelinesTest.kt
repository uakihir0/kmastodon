package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.timelines.TimelinesConversationsRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHashTagTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHomeTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesPublicTimelineRequest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertNotNull

class TimelinesTest : AbstractTest() {

    @Test
    fun testHomeTimeline() = runTest {
        val response = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        assertNotNull(response.data)
        dumpStatuses(response.data)
    }

    @Test
    fun testPublicTimeline() = runTest {
        val response = mastodon().timelines()
            .publicTimeline(TimelinesPublicTimelineRequest())
        assertNotNull(response.data)
        dumpStatuses(response.data)
    }

    @Test
    fun testHashtagTimeline() = runTest {
        val response = mastodon().timelines()
            .hashtagTimeline(
                TimelinesHashTagTimelineRequest().also {
                    it.hashtag = "mastodon"
                }
            )
        assertNotNull(response.data)
        dumpStatuses(response.data)
    }

    @Test
    @Ignore("Requires existing direct message conversations on the test account")
    fun testConversations() = runTest {
        val response = mastodon().timelines()
            .conversations(TimelinesConversationsRequest())
        assertNotNull(response.data)
        println("Conversations count: ${response.data.size}")
    }
}
