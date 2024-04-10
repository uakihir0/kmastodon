package work.socialhub.kmastodon.stream.api

import work.socialhub.kmastodon.stream.listener.HashtagStreamListener
import work.socialhub.kmastodon.stream.listener.LifeCycleListener

interface HashtagStream : EventStream {
    fun register(
        listener: HashtagStreamListener,
        lifeCycle: LifeCycleListener
    ): HashtagStream
}
