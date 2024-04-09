package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Report {

    @SerialName("id")
    var id: String? = null

    @SerialName("actionTaken")
    var actionTaken: String? = null
}
