package work.socialhub.kmastodon.api

import mastodon4j.entity.Trend
import mastodon4j.entity.share.Response

/**
 * @author uakihir0
 */
interface TrendResource {
    /**
     * Retrieving trends.
     * (Since v3.0.0)
     *
     * @return an array of Trends
     */
    fun getTrends(limit: Long?): Response<Array<Trend?>?>?
}
