package work.socialhub.kmastodon.streaming

/**
 *
 * @author hecateball
 */
interface DeleteEventListener {
    fun onDelete(id: Long) {
    }
}
