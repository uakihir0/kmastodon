package work.socialhub.kmastodon.internal.stream

import net.socialhub.logger.Logger

class _StreamEvent internal constructor(consumer: java.util.function.Consumer<_StreamModel?>) {
    private val consumer: java.util.function.Consumer<_StreamModel> =
        consumer

    private var event: _StreamModel? = null

    fun add(line: String?) {
        val trim = line!!.trim { it <= ' ' }

        // nop event
        if (trim == ":thump") {
            event = null
            return
        }

        // check event
        if (trim.startsWith("event")) {
            val events = trim.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (events.size == 2) {
                event = _StreamModel()
                event!!.name = events[1].trim { it <= ' ' }
            }
            return
        }

        // data event
        if (trim.startsWith("data")) {
            val end = trim.length
            val start = trim.indexOf(":") + 1
            val data = trim.substring(start, end)

            event!!.data = data.trim { it <= ' ' }
            LOGGER.debug(event!!.data)
            consumer.accept(event)
            event = null
            return
        }
    }

    class _StreamModel {
        var name: String? = null
        var data: String? = null
    }

    companion object {
        private val LOGGER: Logger = Logger.getLogger(_StreamEvent::class.java)
    }
}
