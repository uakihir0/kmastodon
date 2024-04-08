package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.domain.Service
import net.socialhub.http.HttpRequestBuilder

internal object _PagingUtility {
    private const val PIXELFED_LIMIT_MAX = 50L

    /**
     * Set range params for statuses resources.
     *
     * @param builder
     * @param range
     * @param service
     */
    fun setPagingParams(
        builder: HttpRequestBuilder,
        range: Range?,
        service: Service
    ) {
        if (range != null) {
            // limit

            if (range.getLimit().isPresent()) {
                var limit: Long = range.getLimit().get()
                if ((service === Service.PIXELFED) &&
                    (limit > PIXELFED_LIMIT_MAX)
                ) {
                    limit = PIXELFED_LIMIT_MAX
                }
                builder.query("limit", limit)
            }

            // since_id
            if (range.getSinceId().isPresent()) {
                builder.query("since_id", range.getSinceId().get())
            }

            // max_id
            if (range.getMaxId().isPresent()) {
                builder.query("max_id", range.getMaxId().get())
            }

            // min_id
            if (range.getMinId().isPresent()) {
                builder.query("min_id", range.getMinId().get())
            }
        }
    }
}
