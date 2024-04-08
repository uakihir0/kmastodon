package work.socialhub.kmastodon.entity.share

import net.socialhub.http.HttpResponse
import net.socialhub.logger.Logger

/**
 * @author uakihir0
 */
class RateLimit {
    var limit: Int = 0
    var remaining: Int = 0
    var reset: java.util.Date? = null

    companion object {
        private val logger: Logger = Logger.getLogger(RateLimit::class.java)

        private const val X_RATELIMIT_LIMIT = "X-RateLimit-Limit"

        private const val X_RATELIMIT_REMAINING = "X-RateLimit-Remaining"

        private const val X_RATELIMIT_RESET = "X-RateLimit-Reset"

        fun of(response: HttpResponse?): RateLimit? {
            if (response == null) {
                return null
            }

            try {
                val limit: String = response.getResponseHeader(X_RATELIMIT_LIMIT)
                val remaining: String = response.getResponseHeader(X_RATELIMIT_REMAINING)
                val reset: String = response.getResponseHeader(X_RATELIMIT_RESET)

                val rateLimit = RateLimit()
                rateLimit.limit = limit
                rateLimit.remaining = remaining

                val dates = reset.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val format: java.text.DateFormat = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                format.setTimeZone(java.util.TimeZone.getTimeZone("UTC"))
                rateLimit.reset = format.parse(dates[0])

                return rateLimit
            } catch (e: java.lang.Exception) {
                logger.debug(e.message)
                return null
            }
        }
    }
}
