package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Notification
import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import work.socialhub.kmastodon.stream.api.UserStream
import work.socialhub.kmastodon.stream.listener.UserStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class UserStreamImpl(
    uri: String,
    query: Map<String, String>,
) : BaseStreamImpl(uri, query),
    UserStream {

    var listener: UserStreamListener? = null
    var lifeCycle: LifeCycleListener? = null

    override fun register(
        listener: UserStreamListener,
        lifeCycle: LifeCycleListener,
    ): UserStream {
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
            if (it.event == "notification") {
                fromJson<Notification>(it.payload!!)
                    .let(listener::onNotification)
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
            return "user"
        }
    }
}
