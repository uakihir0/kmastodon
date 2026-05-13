package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test

class MutesTest : AbstractTest() {

    @Test
    fun testMutes() = runTest {
        val response = mastodon().mutes()
            .mutes()
        println("Mutes count: ${response.data.size}")
    }
}
