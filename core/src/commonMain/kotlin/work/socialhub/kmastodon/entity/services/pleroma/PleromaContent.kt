package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PleromaContent {

    @SerialName("text/plain")
    var textPlain: String? = null
}
