package work.socialhub.kmastodon.entity.pleroma

import kotlinx.serialization.SerialName
import kotlin.js.JsExport

@JsExport
class PleromaContent {
    @SerialName("text/plain")
    var textPlain: String? = null
}
