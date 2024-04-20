package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Rules {

    @SerialName("id")
    lateinit var id: String

    @SerialName("text")
    lateinit var text: String
}