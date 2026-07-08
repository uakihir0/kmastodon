package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2 {

    @SerialName("domain")
    var domain: String = ""

    @SerialName("title")
    var title: String = ""

    @SerialName("version")
    var version: String = ""

    @SerialName("source_url")
    var sourceUrl: String = ""

    @SerialName("description")
    var description: String = ""

    @SerialName("usage")
    var usage: InstanceV2Usage? = null

    @SerialName("thumbnail")
    var thumbnail: InstanceV2Thumbnail? = null

    @SerialName("languages")
    var languages: Array<String> = arrayOf()

    @SerialName("configuration")
    var configuration: InstanceV2Configuration? = null

    @SerialName("registrations")
    var registrations: InstanceV2Registrations? = null

    @SerialName("contact")
    var contact: InstanceV2Contact? = null

    @SerialName("rules")
    var rules: Array<InstanceV2Rules> = arrayOf()
}
