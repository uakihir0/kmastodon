package work.socialhub.kmastodon.stream.listener

import work.socialhub.kmastodon.entity.Status

interface UpdateEventListener {
    fun onUpdate(status: Status)
}
