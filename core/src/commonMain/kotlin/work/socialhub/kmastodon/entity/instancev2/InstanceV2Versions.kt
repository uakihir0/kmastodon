package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Versions {

    @SerialName("@1x")
    var at1x: String? = null

    @SerialName("@2x")
    var at2x: String? = null
}