package work.socialhub.kmastodon.streaming

/**
 *
 * @author hecateball
 */
interface EventStream : java.io.Closeable {
    fun open()
}
