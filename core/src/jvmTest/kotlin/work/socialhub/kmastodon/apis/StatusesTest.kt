package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dump
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.statuses.StatusesCardRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesContextRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesFavouritedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPostStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesReblogRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesRebloggedByRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnfavouriteRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnreblogRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesDeleteStatusRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesPinRequest
import work.socialhub.kmastodon.api.request.statuses.StatusesUnpinRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHomeTimelineRequest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class StatusesTest : AbstractTest() {

    @Test
    fun testHomeTimeline() = runTest {
        val response = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        dumpStatuses(response.data)
    }

    @Test
    fun testCreateAndDeleteStatus() = runTest {
        val created = mastodon().statuses().postStatus(
            StatusesPostStatusRequest().also {
                it.status = "Test post from kmastodon StatusesTest"
            }
        ).also { println("Created status: ${it.data.id}") }

        try {
            val fetched = mastodon().statuses().status(
                StatusesStatusRequest().also { it.id = created.data.id }
            ).also { dump(it.data) }
            assertEquals(created.data.id, fetched.data.id)
        } finally {
            mastodon().statuses().deleteStatus(
                StatusesDeleteStatusRequest().also { it.id = created.data.id }
            ).also { println("Deleted status: ${created.data.id}") }
        }
    }

    @Test
    @Ignore
    fun testContext() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().statuses().context(
            StatusesContextRequest().also { it.id = firstId }
        )
        println("Ancestors: ${response.data.ancestors?.size}, Descendants: ${response.data.descendants?.size}")
    }

    @Test
    @Ignore
    fun testCard() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().statuses().card(
            StatusesCardRequest().also { it.id = firstId }
        )
        println("Card: ${response.data.url}")
    }

    @Test
    @Ignore
    fun testRebloggedBy() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().statuses().rebloggedBy(
            StatusesRebloggedByRequest().also { it.id = firstId }
        )
        println("Reblogged by count: ${response.data.size}")
    }

    @Test
    @Ignore
    fun testFavouritedBy() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        val response = mastodon().statuses().favouritedBy(
            StatusesFavouritedByRequest().also { it.id = firstId }
        )
        println("Favourited by count: ${response.data.size}")
    }

    @Test
    @Ignore
    fun testReblogAndUnreblog() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        mastodon().statuses().reblog(
            StatusesReblogRequest().also { it.id = firstId }
        ).also { println("Reblogged: ${it.data.id}") }

        mastodon().statuses().unreblog(
            StatusesUnreblogRequest().also { it.id = firstId }
        ).also { println("Unreblogged: ${it.data.id}") }
    }

    @Test
    @Ignore
    fun testFavouriteAndUnfavourite() = runTest {
        val timeline = mastodon().timelines()
            .homeTimeline(TimelinesHomeTimelineRequest())
        val firstId = timeline.data.firstOrNull()?.id ?: return@runTest

        mastodon().statuses().favourite(
            StatusesFavouriteRequest().also { it.id = firstId }
        ).also { println("Favourited: ${it.data.id}") }

        mastodon().statuses().unfavourite(
            StatusesUnfavouriteRequest().also { it.id = firstId }
        ).also { println("Unfavourited: ${it.data.id}") }
    }

    @Test
    @Ignore
    fun testPinAndUnpin() = runTest {
        val created = mastodon().statuses().postStatus(
            StatusesPostStatusRequest().also {
                it.status = "Test post for pin from kmastodon StatusesTest"
            }
        )

        try {
            mastodon().statuses().pin(
                StatusesPinRequest().also { it.id = created.data.id }
            ).also { println("Pinned: ${it.data.id}") }

            mastodon().statuses().unpin(
                StatusesUnpinRequest().also { it.id = created.data.id }
            ).also { println("Unpinned: ${it.data.id}") }
        } finally {
            mastodon().statuses().deleteStatus(
                StatusesDeleteStatusRequest().also { it.id = created.data.id }
            )
        }
    }
}
