package work.socialhub.kmastodon.stream.listener.primitive

import work.socialhub.kmastodon.entity.Status

interface UpdateEventListener {
    fun onUpdate(status: Status)
}
