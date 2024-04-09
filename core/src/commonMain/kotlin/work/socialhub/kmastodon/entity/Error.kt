package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Error {

    @SerialName("error")
    var error: String? = null

    @SerialName("error_description")
    var description: String? = null
}
