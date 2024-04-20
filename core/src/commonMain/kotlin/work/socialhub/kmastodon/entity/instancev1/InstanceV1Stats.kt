package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Stats {

    @SerialName("user_count")
    var userCount: Int = 0

    @SerialName("status_count")
    var statusCount: Int = 0

    @SerialName("domain_count")
    var domainCount: Int = 0
}