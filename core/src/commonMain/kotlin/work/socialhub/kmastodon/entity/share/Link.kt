package work.socialhub.kmastodon.entity.share

import net.socialhub.http.HttpResponse
import net.socialhub.logger.Logger

/**
 * @author uakihir0
 */
class Link {
    var nextUrl: String? = null
    var prevUrl: String? = null

    var nextMaxId: String? = null
    var prevMinId: String? = null

    companion object {
        private const val LINK = "link"

        fun of(response: HttpResponse?): Link? {
            if (response == null) {
                return null
            }

            try {
                val header: String = response.getResponseHeader(LINK)
                if (header == null || header.isEmpty()) {
                    return null
                }

                // Next と Prev で分割
                val parts = header.split(",\\s?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                val link = Link()
                for (part in parts) {
                    // リンクと rel で分割

                    val elements = part.split(";\\s?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    if (elements.size == 2) {
                        // Next

                        if (elements[1].contains("next")) {
                            val url = extractUrl(elements[0])
                            if (!url.isEmpty()) {
                                link.nextUrl = url
                                link.nextMaxId = extractValue(url, "max_id")
                            }
                        } else if (elements[1].contains("prev")) {
                            val url = extractUrl(elements[0])
                            if (!url.isEmpty()) {
                                link.prevUrl = url
                                link.prevMinId = extractValue(url, "min_id")
                            }
                        }
                    }
                }
                return link
            } catch (e: java.lang.Exception) {
                logger.debug(e.message)
                return null
            }
        }

        private fun extractUrl(element: String): String {
            return element.replace("^\\s?<(.+)>\\s?$".toRegex(), "$1")
        }

        private fun extractValue(url: String, key: String): String {
            val params =
                url.split("\\?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].split("&".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

            return java.util.Arrays.stream<String>(params)
                .map<Array<String>>(java.util.function.Function<String, Array<String>> { e: String ->
                    e.split("=".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                })
                .filter(java.util.function.Predicate<Array<String>> { e: Array<String> ->
                    e[0].equals(
                        key,
                        ignoreCase = true
                    )
                })
                .map<String>(java.util.function.Function<Array<String>, String> { e: Array<String?> -> e[1] })
                .findFirst()
                .orElse(null)
        }
    }
}
