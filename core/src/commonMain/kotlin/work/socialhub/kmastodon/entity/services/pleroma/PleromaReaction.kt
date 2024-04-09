package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PleromaReaction {

    @SerialName("count")
    var count: Int = 0

    @SerialName("me")
    var isMe: Boolean = false

    @SerialName("name")
    var name: String? = null
}
