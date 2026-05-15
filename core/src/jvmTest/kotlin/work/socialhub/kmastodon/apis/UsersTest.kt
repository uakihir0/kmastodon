package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dump
import work.socialhub.kmastodon.Printer.dumpAccounts
import work.socialhub.kmastodon.Printer.dumpStatuses
import work.socialhub.kmastodon.api.request.accounts.AccountsAccountRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsFollowersRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsFollowingRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsRelationshipsRequest
import work.socialhub.kmastodon.api.request.accounts.AccountsStatusesRequest
import kotlin.test.Test

class UsersTest : AbstractTest() {

    @Test
    fun testGetMe() = runTest {
        mastodon().accounts()
            .verifyCredentials()
            .also {
                dump(it.data)
            }
    }

    @Test
    fun testGetAccount() = runTest {
        val me = mastodon().accounts().verifyCredentials()
        val response = mastodon().accounts().account(
            AccountsAccountRequest().also { it.id = me.data.id }
        )
        dump(response.data)
    }

    @Test
    fun testGetFollowers() = runTest {
        val me = mastodon().accounts().verifyCredentials()
        val response = mastodon().accounts().followers(
            AccountsFollowersRequest().also { it.id = me.data.id }
        )
        dumpAccounts(response.data)
    }

    @Test
    fun testGetFollowing() = runTest {
        val me = mastodon().accounts().verifyCredentials()
        val response = mastodon().accounts().following(
            AccountsFollowingRequest().also { it.id = me.data.id }
        )
        dumpAccounts(response.data)
    }

    @Test
    fun testGetStatuses() = runTest {
        val me = mastodon().accounts().verifyCredentials()
        val response = mastodon().accounts().statuses(
            AccountsStatusesRequest().also { it.id = me.data.id }
        )
        dumpStatuses(response.data)
    }

    @Test
    fun testGetRelationships() = runTest {
        val me = mastodon().accounts().verifyCredentials()
        val response = mastodon().accounts().relationships(
            AccountsRelationshipsRequest().also { it.addId(me.data.id) }
        )
        for (rel in response.data) {
            println("Relationship: following=${rel.isFollowing}, followedBy=${rel.isFollowedBy}")
        }
    }
}
