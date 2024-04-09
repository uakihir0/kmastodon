package work.socialhub.kmastodon.entity.share

import work.socialhub.khttpclient.HttpResponse
import kotlin.js.JsExport

@JsExport
class Link {
    var nextUrl: String? = null
    var prevUrl: String? = null

    var nextMaxId: String? = null
    var prevMinId: String? = null

    companion object {
        private const val LINK = "link"

        fun of(
            @Suppress("NON_EXPORTABLE_TYPE")
            response: HttpResponse
        ): Link? {
            try {
                val header = response.headers[LINK]
                if (header.isNullOrEmpty()) {
                    return null
                }

                // Next と Prev で分割
                val parts = header[0]
                    .split(",\\s?".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

                val link = Link()
                for (part in parts) {

                    // リンクと rel で分割
                    val elements = part
                        .split(";\\s?".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()

                    if (elements.size == 2) {

                        if (elements[1].contains("next")) {

                            // Next
                            val url = extractUrl(elements[0])
                            if (url.isNotEmpty()) {
                                link.nextUrl = url
                                link.nextMaxId = extractValue(url, "max_id")
                            }

                        } else if (elements[1].contains("prev")) {

                            // Prev
                            val url = extractUrl(elements[0])
                            if (url.isNotEmpty()) {
                                link.prevUrl = url
                                link.prevMinId = extractValue(url, "min_id")
                            }
                        }
                    }
                }
                return link

            } catch (e: Exception) {
                return null
            }
        }

        private fun extractUrl(element: String): String {
            return element.replace("^\\s?<(.+)>\\s?$".toRegex(), "$1")
        }

        private fun extractValue(
            url: String,
            key: String,
        ): String? {
            val params =
                url.split("\\?".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()[1]
                    .split("&")
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

            return params
                .map { p ->
                    p.split("=")
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                }
                .filter { it[0].equals(key, ignoreCase = true) }
                .map { it[1] }
                .firstOrNull()
        }
    }
}
