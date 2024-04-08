package work.socialhub.kmastodon.api

import mastodon4j.Range
import mastodon4j.entity.Conversation
import mastodon4j.entity.Status
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface TimelinesResource {
    /**
     * Retrieving a home timeline.
     *
     * @return an array of Statuses, most recent ones first
     */
    fun getHomeTimeline(
        range: Range?
    ): Response<Array<Status?>?>?

    /**
     * Retrieving a public timeline.
     *
     * @param local (optional) only return statuses originating from this instance
     * @return an array of Statuses, most recent ones first
     */
    fun getPublicTimeline(
        local: Boolean?,
        onlyMedia: Boolean?,
        range: Range?
    ): Response<Array<Status?>?>?

    /**
     * Retrieving a tag timeline.
     *
     * @param hashtag
     * @param local   (optional) only return statuses originating from this instance
     * @return an array of Statuses, most recent ones first
     */
    fun getHashtagTimeline(
        hashtag: String?,
        local: Boolean?,
        onlyMedia: Boolean?,
        range: Range?
    ): Response<Array<Status?>?>?

    /**
     * Retrieving a list timeline.
     *
     * @param listId
     * @return an array of Statuses, most recent ones first
     */
    fun getListTimeline(
        listId: String?,
        range: Range?
    ): Response<Array<Status?>?>?

    /**
     * Retrieving a conversations.
     *
     * @return an array of Conversations.
     */
    fun getConversations(
        range: Range?
    ): Response<Array<Conversation?>?>?
}
