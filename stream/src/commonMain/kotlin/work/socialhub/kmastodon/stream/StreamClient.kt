package work.socialhub.kmastodon.stream

import work.socialhub.khttpclient.websocket.WebsocketRequest
import work.socialhub.kmastodon.internal.InternalUtility.fromJson

class StreamClient(
    var uri: String
) {
    var client = WebsocketRequest()
    var isOpen: Boolean = false

    var eventCallback: ((StreamResponse) -> Unit)? = null
    var openedCallback: (() -> Unit)? = null
    var closedCallback: (() -> Unit)? = null
    var errorCallback: ((Exception) -> Unit)? = null

    fun eventCallback(callback: (StreamResponse) -> Unit) = also { this.eventCallback = callback }
    fun openedCallback(callback: () -> Unit) = also { this.openedCallback = callback }
    fun closedCallback(callback: () -> Unit) = also { this.closedCallback = callback }
    fun errorCallback(callback: (Exception) -> Unit) = also { this.errorCallback = callback }

    init {
        this.client.url(this.uri)
        this.client.textListener = {
            this.onMessage(it)
        }
        this.client.onOpenListener = {
            this.isOpen = true
            this.openedCallback?.invoke()
        }
        this.client.onCloseListener = {
            this.isOpen = false
            this.closedCallback?.invoke()
        }
    }

    suspend fun open() {
        client.open()
    }

    fun close() {
        client.close()
    }

    private fun onMessage(message: String) {
        this.eventCallback?.let {
            it(fromJson<StreamResponse>(message))
        }
    }
}