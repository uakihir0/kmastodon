package work.socialhub.kmastodon.streaming

interface LifeCycleListener {
    fun onConnect()

    fun onDisconnect()
}
