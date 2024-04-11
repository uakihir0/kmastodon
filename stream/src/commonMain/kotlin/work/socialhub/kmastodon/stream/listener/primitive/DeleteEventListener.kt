package work.socialhub.kmastodon.stream.listener.primitive

interface DeleteEventListener {
    fun onDelete(id: String)
}
