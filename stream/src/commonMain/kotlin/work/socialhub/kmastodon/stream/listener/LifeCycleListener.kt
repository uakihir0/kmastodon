package work.socialhub.kmastodon.stream.listener

interface LifeCycleListener {
    fun onConnect()
    fun onDisconnect()
}
