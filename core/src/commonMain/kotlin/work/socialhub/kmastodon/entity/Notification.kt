package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Notification {

    @SerialName("id")
    var id: String? = null

    @SerialName("type")
    var type: String? = null

    @SerialName("created_at")
    var createdAt: String? = null

    @SerialName("account")
    var account: Account? = null

    @SerialName("status")
    var status: Status? = null
}
