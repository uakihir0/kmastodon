package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dump
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
}
