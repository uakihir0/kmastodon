package work.socialhub.kmastodon.stream.api

import work.socialhub.kmastodon.stream.listener.PublicStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

interface DirectStream : EventStream {
    fun register(
        listener: PublicStreamListener,
        lifeCycle: LifeCycleListener,
    ): DirectStream
}
