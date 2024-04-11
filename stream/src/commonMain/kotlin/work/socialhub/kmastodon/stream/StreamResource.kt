package work.socialhub.kmastodon.stream

import work.socialhub.kmastodon.entity.Tag
import work.socialhub.kmastodon.stream.api.HashtagStream
import work.socialhub.kmastodon.stream.api.PublicStream
import work.socialhub.kmastodon.stream.api.UserStream
import work.socialhub.kmastodon.stream.define.PublicType

interface StreamResource {

    fun userStream(
    ): UserStream

    fun publicStream(
        type: PublicType
    ): PublicStream

    fun hashtagStream(
        tag: String,
        local: Boolean
    ): HashtagStream
}