package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility
import work.socialhub.kmastodon.stream.StreamClient
import work.socialhub.kmastodon.stream.StreamRequest
import work.socialhub.kmastodon.stream.api.HashtagStream
import work.socialhub.kmastodon.stream.listener.HashtagStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class HashtagStreamImpl(
    private val client: StreamClient,
    private val tag: String,
    private val local: Boolean,
) : HashtagStream {

    override fun register(
        listener: HashtagStreamListener,
        lifeCycle: LifeCycleListener,
    ): HashtagStream {
        client.eventCallback = {
            if (it.event == "update") {
                InternalUtility.fromJson<Status>(it.payload!!)
                    .let(listener::onUpdate)
            }
            // TODO: Delete
        }
        client.openedCallback = lifeCycle::onConnect
        client.closedCallback = lifeCycle::onDisconnect
        client.errorCallback = lifeCycle::onError
        return this
    }

    override suspend fun open() {
        client.open()
    }

    override suspend fun start() {
        StreamRequest().also {
            it.type = "subscribe"
            it.stream = streamType()
            it.tag = tag
        }.let { client.client.sendText(InternalUtility.toJson(it)) }
    }

    override suspend fun stop() {
        StreamRequest().also {
            it.type = "unsubscribe"
            it.stream = streamType()
            it.tag = tag
        }.let { client.client.sendText(InternalUtility.toJson(it)) }
    }

    override fun close() {
        client.close()
    }

    override fun isOpen(): Boolean {
        return client.isOpen
    }

    private fun streamType(): String {
        return when (local) {
            true -> "hashtag:local:$tag"
            false -> "hashtag:$tag"
        }
    }
}
