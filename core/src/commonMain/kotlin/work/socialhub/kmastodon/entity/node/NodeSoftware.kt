package work.socialhub.kmastodon.entity.node

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport


@JsExport
@Serializable
class NodeSoftware {

    @SerialName("name")
    var name: String? = null

    @SerialName("version")
    var version: String? = null
}