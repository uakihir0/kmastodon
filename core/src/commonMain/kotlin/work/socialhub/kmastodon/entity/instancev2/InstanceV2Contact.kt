package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.Account
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Contact {

    @SerialName("email")
    lateinit var email: String

    @SerialName("account")
    var account: Account? = null
}