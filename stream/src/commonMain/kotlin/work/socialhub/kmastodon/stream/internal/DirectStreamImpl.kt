package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import work.socialhub.kmastodon.stream.api.DirectStream
import work.socialhub.kmastodon.stream.listener.PublicStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class DirectStreamImpl(
    uri: String,
    query: Map<String, String>,
) : BaseStreamImpl(uri, query),
    DirectStream {

    var listener: PublicStreamListener? = null
    var lifeCycle: LifeCycleListener? = null

    override fun register(
        listener: PublicStreamListener,
        lifeCycle: LifeCycleListener,
    ): DirectStream {
        return also {
            it.listener = listener
            it.lifeCycle = lifeCycle
        }
    }

    override suspend fun open() {
        val listener = checkNotNull(listener) { "listener is required" }
        val lifeCycle = checkNotNull(lifeCycle) { "lifeCycle is required" }
        val client = createClient()

        client.eventCallback = {
            if (it.event == "update") {
                fromJson<Status>(it.payload!!)
                    .let(listener::onUpdate)
            }
        }

        client.openedCallback = lifeCycle::onConnect
        client.closedCallback = lifeCycle::onDisconnect
        client.errorCallback = lifeCycle::onError
        client.open()
    }

    override fun close() {
        client?.close()
    }

    override fun isOpen(): Boolean {
        return client?.isOpen ?: false
    }

    companion object {
        fun type(): String {
            return "direct"
        }
    }
}
