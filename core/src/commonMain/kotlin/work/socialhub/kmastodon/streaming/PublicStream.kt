package work.socialhub.kmastodon.streaming

/**
 *
 * @author hecateball
 */
interface PublicStream : EventStream {
    fun register(listener: PublicStreamListener?, lifeCycle: LifeCycleListener?): PublicStream?
}
