package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2 {

    @SerialName("domain")
    lateinit var domain: String

    @SerialName("title")
    lateinit var title: String

    @SerialName("version")
    lateinit var version: String

    @SerialName("source_url")
    lateinit var sourceUrl: String

    @SerialName("description")
    lateinit var description: String

    @SerialName("usage")
    lateinit var usage: InstanceV2Usage

    @SerialName("thumbnail")
    lateinit var thumbnail: InstanceV2Thumbnail

    @SerialName("languages")
    lateinit var languages: Array<String>

    @SerialName("configuration")
    lateinit var configuration: InstanceV2Configuration

    @SerialName("registrations")
    lateinit var registrations: InstanceV2Registrations

    @SerialName("contact")
    lateinit var contact: InstanceV2Contact

    @SerialName("rules")
    lateinit var rules: Array<InstanceV2Rules>
}
