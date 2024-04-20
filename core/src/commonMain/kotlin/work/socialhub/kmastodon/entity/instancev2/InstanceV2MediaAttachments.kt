package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport


@JsExport
@Serializable
class InstanceV2MediaAttachments {

    @SerialName("supported_mime_types")
    var supportedMimeTypes: Array<String> = arrayOf()

    @SerialName("image_size_limit")
    var imageSizeLimit: Int = 0

    @SerialName("image_matrix_limit")
    var imageMatrixLimit: Int = 0

    @SerialName("video_size_limit")
    var videoSizeLimit: Int = 0

    @SerialName("video_frame_rate_limit")
    var videoFrameRateLimit: Int = 0

    @SerialName("video_matrix_limit")
    var videoMatrixLimit: Int = 0
}