package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dumpAccounts
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.search.SearchSearchRequest
import kotlin.test.Test

class SearchTest : AbstractTest() {

    @Test
    fun testStatuses() {
        val response = mastodon().search().search(
            SearchSearchRequest().also {
                it.query = "SocialHub"
            }
        )
        dumpStatuses(response.data.statuses!!)
    }


    @Test
    fun testUsers() {
        val response = mastodon().search().search(
            SearchSearchRequest().also {
                it.query = "SocialHub"
            }
        )
        dumpAccounts(response.data.accounts!!)
    }
}