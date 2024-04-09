package work.socialhub.kmastodon.entity.share

import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import work.socialhub.khttpclient.HttpResponse
import kotlin.js.JsExport

@JsExport
class RateLimit {
    var limit: Int = 0
    var remaining: Int = 0

    @Suppress("NON_EXPORTABLE_TYPE")
    var reset: Instant? = null

    companion object {
        private const val X_RATELIMIT_LIMIT = "X-RateLimit-Limit"
        private const val X_RATELIMIT_REMAINING = "X-RateLimit-Remaining"
        private const val X_RATELIMIT_RESET = "X-RateLimit-Reset"

        @Suppress("NON_EXPORTABLE_TYPE")
        fun of(response: HttpResponse): RateLimit? {

            try {
                val limit = response.headers[X_RATELIMIT_LIMIT]
                val remaining = response.headers[X_RATELIMIT_REMAINING]
                val reset = response.headers[X_RATELIMIT_RESET]

                return RateLimit().also {
                    if (limit?.isNotEmpty() == true) {
                        it.limit = limit[0].toInt()
                    }
                    if (remaining?.isNotEmpty() == true) {
                        it.remaining = remaining[0].toInt()
                    }
                    if (reset?.isNotEmpty() == true) {
                        it.reset = reset[0].toInstant()
                    }
                }
            } catch (e: Exception) {
                return null
            }
        }
    }
}
