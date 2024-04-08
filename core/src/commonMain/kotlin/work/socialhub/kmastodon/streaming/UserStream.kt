package work.socialhub.kmastodon.streaming

/**
 *
 * @author hecateball
 */
interface UserStream : EventStream {
    fun register(listener: UserStreamListener?, lifeCycle: LifeCycleListener?): UserStream?
}
