package work.socialhub.kmastodon.internal;

import mastodon4j.api.EmojiResource;
import mastodon4j.entity.Emoji;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

public class _EmojiResource implements EmojiResource {

    private final String uri;

    _EmojiResource(String uri) {
        this.uri = uri;
    }

    @Override
    public Response<Emoji[]> getCustomEmojis() {
        return proceed(Emoji[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/custom_emojis")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .get();
        });
    }
}
