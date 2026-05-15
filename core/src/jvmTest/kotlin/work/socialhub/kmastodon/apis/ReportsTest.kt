package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.reports.ReportsPostReportRequest
import kotlin.test.Ignore
import kotlin.test.Test

class ReportsTest : AbstractTest() {

    @Test
    fun testReports() = runTest {
        val response = mastodon().reports()
            .reports()
        println("Reports count: ${response.data.size}")
    }

    @Test
    @Ignore
    fun testPostReport() = runTest {
        mastodon().reports().postReport(
            ReportsPostReportRequest().also {
                it.accountId = "REQUIRED_ACCOUNT_ID"
                it.comment = "Test report from kmastodon"
            }
        )
    }
}
