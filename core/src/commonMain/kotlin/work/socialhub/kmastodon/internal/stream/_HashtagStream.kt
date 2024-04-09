package work.socialhub.kmastodon.internal.stream

import com.google.gson.Gson
import mastodon4j.MastodonException
import mastodon4j.entity.Status
import mastodon4j.streaming.HashtagStream
import mastodon4j.streaming.HashtagStreamListener
import mastodon4j.streaming.LifeCycleListener
import net.socialhub.http.HttpRequestBuilder
import net.socialhub.http.HttpResponse
import net.socialhub.logger.Logger
import work.socialhub.kmastodon.internal.InternalUtility

/**
 * @author hecateball
 */
internal class _HashtagStream(builder: HttpRequestBuilder) : HashtagStream {
    private val builder: HttpRequestBuilder = builder
    private var lifeCycle: LifeCycleListener? = null
    private var streamEvent: _StreamEvent? = null
    private var thread: java.lang.Thread? = null
    private var isOpen = false
    private val gson: Gson = InternalUtility.getGsonInstance()

    fun register(listener: HashtagStreamListener, lifeCycle: LifeCycleListener?): HashtagStream {
        this.streamEvent = _StreamEvent { event ->
            when (event.getName()) {
                "update" -> listener.onUpdate(gson.fromJson(event.getData(), Status::class.java))
                "notification" -> {}
                "delete" -> listener.onDelete(gson.fromJson(event.getData(), Long::class.java))
                else -> LOGGER.debug("Unexpected event name: " + event.getName())
            }
        }
        this.lifeCycle = lifeCycle
        return this
    }

    fun open() {
        if (!isOpen) {
            thread = java.lang.Thread(java.lang.Runnable {
                try {
                    val response: HttpResponse = builder.get()
                    val reader: java.io.BufferedReader =
                        java.io.BufferedReader(java.io.InputStreamReader(response.asStream(), "UTF-8"))
                    if (lifeCycle != null) {
                        lifeCycle.onConnect()
                    }
                    var line: String

                    do {
                        line = reader.readLine()
                        streamEvent!!.add(line)
                        java.lang.Thread.sleep(100)
                    } while (line != null)
                } catch (e: java.lang.InterruptedException) {
                    isOpen = false
                    // close connection
                    if (lifeCycle != null) {
                        lifeCycle.onDisconnect()
                    }
                } catch (e: java.lang.Exception) {
                    isOpen = false
                    // http exception
                    if (lifeCycle != null) {
                        lifeCycle.onDisconnect()
                    }
                    throw MastodonException(e)
                }
            })
            thread.start()
            isOpen = true
        }
    }

    fun close() {
        if (isOpen) {
            thread.interrupt()
            isOpen = false
        }
    }

    companion object {
        private val LOGGER: Logger = Logger.getLogger(_HashtagStream::class.java)
    }
}
