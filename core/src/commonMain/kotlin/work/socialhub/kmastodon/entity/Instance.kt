package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Instance {

    var uri: String? = null
    var title: String? = null
    var description: String? = null
    var email: String? = null
}
