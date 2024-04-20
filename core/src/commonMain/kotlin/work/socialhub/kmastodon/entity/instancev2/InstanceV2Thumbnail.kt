package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Thumbnail {

    @SerialName("url")
    lateinit var url: String

    @SerialName("blurhash")
    var blurhash: String? = null

    @SerialName("versions")
    var versions: InstanceV2Versions? = null
}