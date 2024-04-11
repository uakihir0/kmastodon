package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility
import work.socialhub.kmastodon.stream.StreamClient
import work.socialhub.kmastodon.stream.StreamRequest
import work.socialhub.kmastodon.stream.api.PublicStream
import work.socialhub.kmastodon.stream.define.PublicType
import work.socialhub.kmastodon.stream.listener.PublicStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class PublicStreamImpl(
    private val client: StreamClient,
    private val type: PublicType,
) : PublicStream {

    override fun register(
        listener: PublicStreamListener,
        lifeCycle: LifeCycleListener,
    ): PublicStream {
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
        }.let { client.client.sendText(InternalUtility.toJson(it)) }
    }

    override suspend fun stop() {
        StreamRequest().also {
            it.type = "unsubscribe"
            it.stream = streamType()
        }.let { client.client.sendText(InternalUtility.toJson(it)) }
    }

    override fun close() {
        client.close()
    }

    override fun isOpen(): Boolean {
        return client.isOpen
    }

    private fun streamType(): String {
        return when (type) {
            PublicType.LOCAL -> "public:local"
            PublicType.REMOTE -> "public:remote"
            PublicType.ALL -> "public"
        }
    }
}
