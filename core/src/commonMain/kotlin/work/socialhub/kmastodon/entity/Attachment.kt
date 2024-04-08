package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Attachment : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("remote_url")
    var remoteUrl: String? = null

    @SerializedName("preview_url")
    var previewUrl: String? = null

    @SerializedName("text_url")
    var textUrl: String? = null

    // for PixelFed
    // for PixelFed
    @SerializedName("optimized_url")
    var optimizedUrl: String? = null

    @SerializedName("meta")
    var meta: Meta? = null

    @SerializedName("orientation")
    var orientation: String? = null
}
