package work.socialhub.kmastodon.entity.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class FilterResult {
    var filter: Filter? = null

    @SerialName("keyword_matches")
    var keywordMatches: Array<String>? = null

    @SerialName("status_matches")
    var statusMatches: Array<String>? = null
}