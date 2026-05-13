package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.lists.ListsCreateListRequest
import work.socialhub.kmastodon.api.request.lists.ListsDeleteListRequest
import work.socialhub.kmastodon.api.request.lists.ListsListRequest
import kotlin.test.Ignore
import kotlin.test.Test

class ListsTest : AbstractTest() {

    @Test
    @Ignore
    fun testCreateAndDeleteList() = runTest {
        val created = mastodon().lists().createList(
            ListsCreateListRequest().also {
                it.title = "Test List from kmastodon"
            }
        ).also { println("Created list: ${it.data.id} - ${it.data.title}") }

        val fetched = mastodon().lists().list(
            ListsListRequest().also { it.id = created.data.id }
        ).also { println("Fetched list: ${it.data.id} - ${it.data.title}") }

        mastodon().lists().deleteList(
            ListsDeleteListRequest().also { it.id = created.data.id }
        ).also { println("Deleted list: ${created.data.id}") }
    }
}
