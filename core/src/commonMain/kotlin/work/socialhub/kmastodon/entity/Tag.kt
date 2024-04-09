package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Tag {

    var name: String? = null
    var url: String? = null
    var history: Array<History>? = null
}
