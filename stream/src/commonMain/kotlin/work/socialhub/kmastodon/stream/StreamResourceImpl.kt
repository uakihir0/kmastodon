package work.socialhub.kmastodon.stream

import io.ktor.http.*
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
            StreamClient(url(
                Url(uri).host,
                "user",
                checkNotNull(accessToken) {
                    "needs access token"
                }
            )))
    }

    override fun publicStream(
        type: PublicType
    ): PublicStream {
        return PublicStreamImpl(
            StreamClient(url(
                Url(uri).host,
                PublicStreamImpl.type(type),
                checkNotNull(accessToken) {
                    "needs access token"
                }
            )))
    }

    override fun hashtagStream(
        tag: String,
        local: Boolean,
    ): HashtagStream {
        return HashtagStreamImpl(
            StreamClient(url(
                Url(uri).host,
                HashtagStreamImpl.type(local),
                checkNotNull(accessToken) {
                    "needs access token"
                }
            )))
    }

    private fun url(
        host: String,
        type: String,
        accessToken: String,
        tag: String? = null,
        list: String? = null,
    ): String {
        var url = "wss://streaming.${host}/api/v1/streaming"
        url += "?access_token=$accessToken"
        url += "&stream=$type"
        tag?.let { url += "&tag=$it" }
        list?.let { url += "&list=$it" }
        return url;
    }
}