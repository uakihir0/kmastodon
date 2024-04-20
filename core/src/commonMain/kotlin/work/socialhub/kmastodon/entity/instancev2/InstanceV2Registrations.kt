package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Registrations {

    @SerialName("enabled")
    var enabled: Boolean = false

    @SerialName("approval_required")
    var approvalRequired: Boolean = false

    @SerialName("message")
    var message: String? = null
}