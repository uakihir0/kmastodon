package work.socialhub.kmastodon.api

import mastodon4j.entity.Tag
import mastodon4j.streaming.HashtagStream
import mastodon4j.streaming.PublicStream
import mastodon4j.streaming.UserStream

/**
 * @author hecateball
 */
interface StreamingResource {
    /**
     * Returns events that are relevant to the authorized user, i.e. home timeline and notifications.
     *
     * @return /api/v1/streaming/user
     */
    fun userStream(): UserStream?

    /**
     * Returns all public statuses.
     *
     * @return /api/v1/streaming/public
     */
    fun publicStream(): PublicStream?

    /**
     * Return local public statuses.
     *
     * @param local
     * @return /api/v1/streaming/public/local
     */
    fun publicStream(local: Boolean): PublicStream?

    /**
     * Returns all public statuses for a particular hashtag.
     *
     * @param tag
     * @return /api/v1/streaming/hashtag
     */
    fun hashtagStream(tag: Tag?): HashtagStream?

    /**
     * Returns local public statuses for a particular hashtag.
     *
     * @param tag
     * @param local
     * @return /api/v1/streaming/hashtag/local
     */
    fun hashtagStream(tag: Tag?, local: Boolean): HashtagStream?
}
