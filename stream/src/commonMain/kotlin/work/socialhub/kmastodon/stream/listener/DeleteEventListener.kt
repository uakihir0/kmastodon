package work.socialhub.kmastodon.stream.listener

interface DeleteEventListener {
    fun onDelete(id: String)
}
