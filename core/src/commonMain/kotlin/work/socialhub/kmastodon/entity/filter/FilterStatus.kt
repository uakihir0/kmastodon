package work.socialhub.kmastodon.entity.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class FilterStatus {
    var id: String = ""

    @SerialName("status_id")
    var statusId: String = ""
}