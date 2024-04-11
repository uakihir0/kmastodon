package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.Printer.dump
import kotlin.test.Test

class UsersTest : AbstractTest() {

    @Test
    fun testGetMe() {
        mastodon().accounts()
            .verifyCredentials()
            .also {
                dump(it.data)
            }
    }
}