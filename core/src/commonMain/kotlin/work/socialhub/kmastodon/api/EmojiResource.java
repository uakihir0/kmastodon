package work.socialhub.kmastodon.api;

import mastodon4j.entity.Emoji;
import mastodon4j.entity.share.Response;

/**
 * @author uakihir0
 */
public interface EmojiResource {

    /**
     * Get custom emojis.
     */
    public Response<Emoji[]> getCustomEmojis();
}
