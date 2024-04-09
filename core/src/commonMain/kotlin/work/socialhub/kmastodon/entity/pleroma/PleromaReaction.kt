package work.socialhub.kmastodon.entity.pleroma

import kotlinx.serialization.SerialName
import kotlin.js.JsExport

@JsExport
class PleromaReaction {
    @SerialName("count")
    var count: Int = 0

    @SerialName("me")
    var isMe: Boolean = false

    @SerialName("name")
    var name: String? = null
}
