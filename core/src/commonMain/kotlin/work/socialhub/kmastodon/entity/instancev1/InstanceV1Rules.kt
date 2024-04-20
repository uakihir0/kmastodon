package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Rules {

    @SerialName("id")
    var id: String? = null

    @SerialName("text")
    var text: String? = null
}