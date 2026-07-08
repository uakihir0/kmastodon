package work.socialhub.kmastodon.entity.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class FilterKeyword {
    var id: String = ""
    var keyword: String = ""

    @SerialName("whole_word")
    var isWholeWord: Boolean = false
}