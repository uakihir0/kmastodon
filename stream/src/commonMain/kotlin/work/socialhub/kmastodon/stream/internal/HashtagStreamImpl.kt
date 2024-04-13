package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility
import work.socialhub.kmastodon.stream.StreamClient
import work.socialhub.kmastodon.stream.api.HashtagStream
import work.socialhub.kmastodon.stream.listener.HashtagStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class HashtagStreamImpl(
    private val client: StreamClient,
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

    override fun close() {
        client.close()
    }

    override fun isOpen(): Boolean {
        return client.isOpen
    }

    companion object {
        fun type(local: Boolean): String {
            return when (local) {
                true -> "hashtag:local"
                false -> "hashtag"
            }
        }
    }
}
