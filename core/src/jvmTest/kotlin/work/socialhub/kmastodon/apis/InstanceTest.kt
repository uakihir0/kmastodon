package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test
import kotlin.test.assertNotNull


class InstanceTest : AbstractTest(){

    @Test
    fun testInstanceV1() = runTest {
        val response = mastodon().instances().instanceV1()
        assertNotNull(response.data.urls.streamingApi)
        println(response.data.urls.streamingApi)
    }

    @Test
    fun testInstanceV2() = runTest {
        val response = mastodon().instances().instanceV2()
        assertNotNull(response.data.configuration.urls.streaming)
        println(response.data.configuration.urls.streaming)
    }
}
