package work.socialhub.kmastodon.internal;

import mastodon4j.Range;
import mastodon4j.domain.Service;
import net.socialhub.http.HttpRequestBuilder;

class _PagingUtility {

    private static final Long PIXELFED_LIMIT_MAX = 50L;

    /**
     * Set range params for statuses resources.
     *
     * @param builder
     * @param range
     * @param service
     */
    static void setPagingParams(
            HttpRequestBuilder builder,
            Range range,
            Service service) {

        if (range != null) {

            // limit
            if (range.getLimit().isPresent()) {
                Long limit = range.getLimit().get();
                if ((service == Service.PIXELFED) &&
                        (limit > PIXELFED_LIMIT_MAX)) {
                    limit = PIXELFED_LIMIT_MAX;
                }
                builder.query("limit", limit);
            }

            // since_id
            if (range.getSinceId().isPresent()) {
                builder.query("since_id", range.getSinceId().get());
            }

            // max_id
            if (range.getMaxId().isPresent()) {
                builder.query("max_id", range.getMaxId().get());
            }

            // min_id
            if (range.getMinId().isPresent()) {
                builder.query("min_id", range.getMinId().get());
            }
        }
    }
}
