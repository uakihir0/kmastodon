package work.socialhub.kmastodon.stream.listener.primitive

interface LifeCycleListener {
    fun onConnect()
    fun onDisconnect()
    fun onError(e: Exception)
}
