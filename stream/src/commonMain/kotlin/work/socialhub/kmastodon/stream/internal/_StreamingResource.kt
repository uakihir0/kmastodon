package work.socialhub.kmastodon.stream.internal

import mastodon4j.api.StreamingResource
import mastodon4j.entity.Tag
import mastodon4j.internal._InternalUtility.getBearerToken
import mastodon4j.streaming.HashtagStream
import mastodon4j.streaming.PublicStream
import mastodon4j.streaming.UserStream
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _StreamingResource(private val uri: String, accessToken: String?) : StreamingResource {
    init {
        // User Stream
        if (USER_STREAM == null) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(uri).path("/api/v1/streaming/user")

            if (accessToken != null) {
                val bearerToken: String = getBearerToken(accessToken)
                builder.header("Authorization", bearerToken)
            }
            USER_STREAM = _UserStream(builder)
        }

        // Public Stream
        if (PUBLIC_STREAM == null) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(uri).path("/api/v1/streaming/public")
            PUBLIC_STREAM = _PublicStream(builder)
        }

        // Local Public Stream
        if (LOCAL_PUBLIC_STREAM == null) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(uri).path("/api/v1/streaming/public/local")
            LOCAL_PUBLIC_STREAM = _PublicStream(builder)
        }
    }

    /**
     * {@inheritDoc}
     */
    fun userStream(): UserStream? {
        return USER_STREAM
    }

    /**
     * {@inheritDoc}
     */
    fun publicStream(): PublicStream? {
        return PUBLIC_STREAM
    }

    /**
     * {@inheritDoc}
     */
    fun publicStream(local: Boolean): PublicStream? {
        return if (local) LOCAL_PUBLIC_STREAM else PUBLIC_STREAM
    }

    /**
     * {@inheritDoc}
     */
    fun hashtagStream(tag: Tag): HashtagStream {
        return this.hashtagStream(tag, false)
    }

    /**
     * {@inheritDoc}
     */
    fun hashtagStream(tag: Tag, local: Boolean): HashtagStream {
        val builder: HttpRequestBuilder = HttpRequestBuilder()
            .target(this.uri).path("/api/v1/streaming/hashtag")

        if (local) {
            builder.path("/api/v1/streaming/hashtag/local")
        }

        builder.query("tag", tag.getName())
        return _HashtagStream(builder)
    }

    companion object {
        private var USER_STREAM: UserStream? = null
        private var PUBLIC_STREAM: PublicStream? = null
        private var LOCAL_PUBLIC_STREAM: PublicStream? = null
    }
}
