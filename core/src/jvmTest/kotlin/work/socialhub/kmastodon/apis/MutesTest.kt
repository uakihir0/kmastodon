package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class MutesTest : AbstractTest() {

    @Test
    fun testMutes() = runTest {
        val response = mastodon().mutes()
            .mutes()
        assertNotNull(response.data)
        println("Mutes count: ${response.data.size}")
    }
}
