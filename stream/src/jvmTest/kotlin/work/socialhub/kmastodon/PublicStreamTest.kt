package work.socialhub.kmastodon

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.test.Ignore
import kotlin.test.Test
import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.stream.MastodonEx.stream
import work.socialhub.kmastodon.stream.define.PublicType
import work.socialhub.kmastodon.stream.listener.PublicStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class PublicStreamTest : AbstractTest() {

    @Test
    @Ignore("Requires WebSocket connectivity to the Mastodon instance")
    fun testPublicStream() {
        val stream = mastodon().stream().publicStream(PublicType.ALL)

        stream.register(object : PublicStreamListener {
            override fun onUpdate(status: Status) {
                println(status.id)
            }

            override fun onDelete(id: String) {}
        }, object : LifeCycleListener {
            override fun onConnect() {
                println("opened")
            }
            override fun onDisconnect() {}
            override fun onError(e: Exception) {}
        }
        )

        runBlocking {
            launch { stream.open() }
            delay(20000)
        }
    }
}