package work.socialhub.kmastodon.api;

import mastodon4j.entity.Trend;
import mastodon4j.entity.share.Response;

/**
 * @author uakihir0
 */
public interface TrendResource {

    /**
     * Retrieving trends.
     * (Since v3.0.0)
     *
     * @return an array of Trends
     */
    public Response<Trend[]> getTrends(Long limit);
}
