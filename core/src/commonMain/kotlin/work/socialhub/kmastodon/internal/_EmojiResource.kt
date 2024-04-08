package work.socialhub.kmastodon.internal

import mastodon4j.api.EmojiResource
import mastodon4j.entity.Emoji
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

class _EmojiResource internal constructor(private val uri: String) : EmojiResource {
    val customEmojis: Response<Array<Emoji>>
        get() = proceed(Array<Emoji>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/custom_emojis")
                .request(HttpMediaType.APPLICATION_JSON)
                .get()
        }
}
