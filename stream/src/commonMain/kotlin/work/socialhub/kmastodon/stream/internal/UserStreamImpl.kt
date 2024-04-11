package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.entity.Notification
import work.socialhub.kmastodon.entity.Status
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import work.socialhub.kmastodon.internal.InternalUtility.toJson
import work.socialhub.kmastodon.stream.StreamClient
import work.socialhub.kmastodon.stream.StreamRequest
import work.socialhub.kmastodon.stream.api.UserStream
import work.socialhub.kmastodon.stream.listener.UserStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

class UserStreamImpl(
    private val client: StreamClient,
    private val accessToken: String,
) : UserStream {

    override fun register(
        listener: UserStreamListener,
        lifeCycle: LifeCycleListener,
    ): UserStream {
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
        return this
    }

    override suspend fun open() {
        client.open()
    }

    override suspend fun start() {
        StreamRequest().also {
            it.accessToken = accessToken
            it.type = "subscribe"
            it.stream = "user"
        }.let { client.client.sendText(toJson(it)) }

        StreamRequest().also {
            it.accessToken = accessToken
            it.type = "subscribe"
            it.stream = "user:notification"
        }.let { client.client.sendText(toJson(it)) }
    }

    override suspend fun stop() {
        StreamRequest().also {
            it.accessToken = accessToken
            it.type = "unsubscribe"
            it.stream = "user"
        }.let { client.client.sendText(toJson(it)) }

        StreamRequest().also {
            it.accessToken = accessToken
            it.type = "unsubscribe"
            it.stream = "user:notification"
        }.let { client.client.sendText(toJson(it)) }
    }

    override fun close() {
        client.close()
    }

    override fun isOpen(): Boolean {
        return client.isOpen
    }
}
