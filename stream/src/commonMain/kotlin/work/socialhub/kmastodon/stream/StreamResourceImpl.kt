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
            uri,
            mapOf(
                "access_token" to accessToken(),
                "stream" to UserStreamImpl.type()
            )
        )
    }

    override fun publicStream(
        type: PublicType
    ): PublicStream {
        return PublicStreamImpl(
            uri,
            mapOf(
                "access_token" to accessToken(),
                "stream" to PublicStreamImpl.type(type)
            )
        )
    }

    override fun hashtagStream(
        tag: String,
        local: Boolean,
    ): HashtagStream {
        return HashtagStreamImpl(
            uri,
            mapOf(
                "access_token" to accessToken(),
                "stream" to HashtagStreamImpl.type(local),
                "tag" to tag
            )
        )
    }

    private fun accessToken(): String {
        return checkNotNull(accessToken) {
            "needs access token"
        }
    }
}