package work.socialhub.kmastodon.stream.api

import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener
import work.socialhub.kmastodon.stream.listener.PublicStreamListener

interface PublicStream : EventStream {
    fun register(
        listener: PublicStreamListener,
        lifeCycle: LifeCycleListener,
    ): PublicStream
}
