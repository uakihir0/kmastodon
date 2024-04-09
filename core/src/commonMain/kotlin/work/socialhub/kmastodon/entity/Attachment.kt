package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.meta.Meta
import kotlin.js.JsExport

@JsExport
@Serializable
class Attachment  {

    @SerialName("id")
    var id: String? = null

    @SerialName("type")
    var type: String? = null

    @SerialName("url")
    var url: String? = null

    @SerialName("remote_url")
    var remoteUrl: String? = null

    @SerialName("preview_url")
    var previewUrl: String? = null

    @SerialName("text_url")
    var textUrl: String? = null

    // for PixelFed
    @SerialName("optimized_url")
    var optimizedUrl: String? = null

    @SerialName("meta")
    var meta: Meta? = null

    @SerialName("orientation")
    var orientation: String? = null
}
