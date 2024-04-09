package work.socialhub.kmastodon.entity.node

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Node {

    @SerialName("version")
    var version: String? = null

    @SerialName("software")
    var software: NodeSoftware? = null

    @SerialName("protocols")
    var protocols: Array<String>? = null

    @SerialName("openRegistrations")
    var openRegistrations: Boolean? = null
}
