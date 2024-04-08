package work.socialhub.kmastodon.streaming

/**
 *
 * @author hecateball
 */
interface HashtagStream : EventStream {
    fun register(listener: HashtagStreamListener?, lifeCycle: LifeCycleListener?): HashtagStream?
}
