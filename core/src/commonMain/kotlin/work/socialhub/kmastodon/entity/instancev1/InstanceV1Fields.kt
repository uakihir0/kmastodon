package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Fields {

    @SerialName("name")
    var name: String? = null

    @SerialName("value")
    var value: String? = null

    @SerialName("verified_at")
    var verifiedAt: String? = null
}