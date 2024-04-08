package work.socialhub.kmastodon.api

import mastodon4j.Page
import mastodon4j.entity.Results
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface SearchResource {
    /**
     * Searching for content.
     *
     * @param query   the search query
     * @param resolve whether to resolve non-local accounts
     * @return Results. If query is a URL, Mastodon will attempt to fetch the provided account or status. Otherwise, it
     * will do a local account and hashtag search
     */
    fun search(
        query: String?,
        resolve: Boolean,
        onlyFollowing: Boolean,
        page: Page?
    ): Response<Results?>?
}
