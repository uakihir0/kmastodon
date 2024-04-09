package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Alert {
    @SerialName("follow")
    var follow: Boolean? = null

    @SerialName("favourite")
    var favourite: Boolean? = null

    @SerialName("reblog")
    var reblog: Boolean? = null

    @SerialName("mention")
    var mention: Boolean? = null

    @SerialName("poll")
    var poll: Boolean? = null

    @SerialName("status")
    var status: Boolean? = null
}
