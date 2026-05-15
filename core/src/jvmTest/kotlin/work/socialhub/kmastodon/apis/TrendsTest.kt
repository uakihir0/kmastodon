package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.trends.TrendsTrendsRequest
import kotlin.test.Test

class TrendsTest : AbstractTest() {

    @Test
    fun testTrends() = runTest {
        val response = mastodon().trends()
            .trends(TrendsTrendsRequest())
        println("Trends count: ${response.data.size}")
    }
}
