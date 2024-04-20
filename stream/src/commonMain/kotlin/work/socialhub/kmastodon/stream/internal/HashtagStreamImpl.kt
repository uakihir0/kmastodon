package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility
import work.socialhub.kmastodon.stream.api.HashtagStream
import work.socialhub.kmastodon.stream.listener.HashtagStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class HashtagStreamImpl(
    uri: String,
    query: Map<String, String>,
) : BaseStreamImpl(uri, query),
    HashtagStream {

    var listener: HashtagStreamListener? = null
    var lifeCycle: LifeCycleListener? = null

    override fun register(
        listener: HashtagStreamListener,
        lifeCycle: LifeCycleListener,
    ): HashtagStream {
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
                InternalUtility.fromJson<Status>(it.payload!!)
                    .let(listener::onUpdate)
            }
            // TODO: Delete
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
        fun type(local: Boolean): String {
            return when (local) {
                true -> "hashtag:local"
                false -> "hashtag"
            }
        }
    }
}
