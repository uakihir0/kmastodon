package work.socialhub.kmastodon.stream.api

import work.socialhub.kmastodon.stream.listener.UserStreamListener
import work.socialhub.kmastodon.stream.listener.primitive.LifeCycleListener

interface UserStream : EventStream {
    fun register(
        listener: UserStreamListener,
        lifeCycle: LifeCycleListener,
    ): UserStream
}
