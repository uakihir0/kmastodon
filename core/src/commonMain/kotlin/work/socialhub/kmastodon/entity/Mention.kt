package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Mention {

    @SerialName("url")
    var url: String? = null

    @SerialName("id")
    var id: String? = null

    @SerialName("username")
    var userName: String? = null

    @SerialName("acct")
    var account: String? = null
}
