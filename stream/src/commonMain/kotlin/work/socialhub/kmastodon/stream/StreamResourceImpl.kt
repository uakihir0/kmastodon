package work.socialhub.kmastodon.stream

import work.socialhub.kmastodon.stream.api.HashtagStream
import work.socialhub.kmastodon.stream.api.PublicStream
import work.socialhub.kmastodon.stream.api.UserStream
import work.socialhub.kmastodon.stream.define.PublicType
import work.socialhub.kmastodon.stream.internal.HashtagStreamImpl
import work.socialhub.kmastodon.stream.internal.PublicStreamImpl
import work.socialhub.kmastodon.stream.internal.UserStreamImpl

class StreamResourceImpl(
    private val uri: String,
    private val accessToken: String?
) : StreamResource {

    override fun userStream(): UserStream {
        return UserStreamImpl(
            StreamClient("${uri}/api/v1/streaming"),
            checkNotNull(accessToken) {
                "needs access token"
            }
        )
    }

    override fun publicStream(
        type: PublicType
    ): PublicStream {
        return PublicStreamImpl(
            StreamClient("${uri}/api/v1/streaming"),
            type
        )
    }

    override fun hashtagStream(
        tag: String,
        local: Boolean,
    ): HashtagStream {
        return HashtagStreamImpl(
            StreamClient("${uri}/api/v1/streaming"),
            tag,
            local
        )
    }
}