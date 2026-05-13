package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.timelines.TimelinesConversationsRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHashTagTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesPublicTimelineRequest
import kotlin.test.Ignore
import kotlin.test.Test

class TimelinesTest : AbstractTest() {

    @Test
    fun testPublicTimeline() = runTest {
        val response = mastodon().timelines()
            .publicTimeline(TimelinesPublicTimelineRequest())
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
        dumpStatuses(response.data)
    }

    @Test
    @Ignore
    fun testConversations() = runTest {
        val response = mastodon().timelines()
            .conversations(TimelinesConversationsRequest())
        println("Conversations count: ${response.data.size}")
    }
}
