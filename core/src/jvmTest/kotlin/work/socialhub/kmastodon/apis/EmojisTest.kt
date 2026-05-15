package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class EmojisTest : AbstractTest() {

    @Test
    fun testCustomEmojis() = runTest {
        val response = mastodon().emojis()
            .customEmojis()
        assertNotNull(response.data)
        println("Custom emojis count: ${response.data.size}")
    }
}
