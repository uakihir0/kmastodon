package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class AccessToken {

    @SerialName("access_token")
    var accessToken: String? = null

    @SerialName("token_type")
    var tokenType: String? = null

    @SerialName("scope")
    var scope: String? = null

    @SerialName("created_at")
    var createdAt: Int = 0

    @SerialName("refresh_token")
    var refreshToken: String? = null

    @SerialName("expires_in")
    var expiresIn: Int? = null
}
