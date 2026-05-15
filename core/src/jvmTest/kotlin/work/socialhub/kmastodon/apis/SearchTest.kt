package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpAccounts
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.search.SearchSearchRequest
import kotlin.test.Test
import kotlin.test.assertNotNull

class SearchTest : AbstractTest() {

    @Test
    fun testStatuses() = runTest {
        val response = mastodon().search().search(
            SearchSearchRequest().also {
                it.query = "SocialHub"
            }
        )
        assertNotNull(response.data.statuses)
        dumpStatuses(response.data.statuses!!)
    }


    @Test
    fun testUsers() = runTest {
        val response = mastodon().search().search(
            SearchSearchRequest().also {
                it.query = "SocialHub"
            }
        )
        assertNotNull(response.data.accounts)
        dumpAccounts(response.data.accounts!!)
    }
}
