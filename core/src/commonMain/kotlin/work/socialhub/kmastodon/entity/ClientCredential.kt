package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class ClientCredential {

    @SerialName("id")
    var id: String? = null

    @SerialName("redirect_uri")
    var redirectUri: String? = null

    @SerialName("client_id")
    var clientId: String? = null

    @SerialName("client_secret")
    var clientSecret: String? = null
}
