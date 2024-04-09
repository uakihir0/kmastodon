package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Conversation {

    @SerialName("id")
    var id: String? = null

    @SerialName("accounts")
    var accounts: Array<Account>? = null

    @SerialName("last_status")
    var lastStatus: Status? = null

    @SerialName("unread")
    var unread: Boolean? = null
}
