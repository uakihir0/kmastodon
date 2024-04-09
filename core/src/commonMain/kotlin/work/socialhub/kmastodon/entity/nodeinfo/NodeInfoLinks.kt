package work.socialhub.kmastodon.entity.nodeinfo

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class NodeInfoLinks {

    var href: String? = null
    var rel: String? = null
}