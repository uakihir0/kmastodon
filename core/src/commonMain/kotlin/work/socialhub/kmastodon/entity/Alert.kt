package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Alert {

    var follow: Boolean? = null
    var favourite: Boolean? = null
    var reblog: Boolean? = null
    var mention: Boolean? = null
    var poll: Boolean? = null
    var status: Boolean? = null
}
