package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import kotlin.test.Test


class InstanceTest : AbstractTest(){

    @Test
    fun testInstanceV1() {
        val response = mastodon().instances().instanceV1()
        println(response.data.urls.streamingApi)
    }

    @Test
    fun testInstanceV2() {
        val response = mastodon().instances().instanceV2()
        println(response.data.configuration.urls.streaming)
    }
}