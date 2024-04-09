package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Subscription {

    @SerialName("id")
    var id: Int? = null

    @SerialName("endpoint")
    var endpoint: String? = null

    @SerialName("alerts")
    var alerts: Alert? = null

    @SerialName("server_key")
    var serverKey: String? = null
}

