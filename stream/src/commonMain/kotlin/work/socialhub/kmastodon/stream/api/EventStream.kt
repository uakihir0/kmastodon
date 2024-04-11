package work.socialhub.kmastodon.stream.api

interface EventStream {
    suspend fun open()
    fun close()
    fun isOpen(): Boolean
}
