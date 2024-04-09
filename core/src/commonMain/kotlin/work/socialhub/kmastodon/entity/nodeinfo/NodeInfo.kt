package work.socialhub.kmastodon.entity.nodeinfo

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class NodeInfo {

    var links: Array<NodeInfoLinks>? = null
}


