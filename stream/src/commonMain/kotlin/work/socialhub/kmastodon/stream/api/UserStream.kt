package work.socialhub.kmastodon.stream.api

import work.socialhub.kmastodon.stream.listener.LifeCycleListener
import work.socialhub.kmastodon.stream.listener.UserStreamListener

interface UserStream : EventStream {
    fun register(
        listener: UserStreamListener,
        lifeCycle: LifeCycleListener,
    ): UserStream
}
