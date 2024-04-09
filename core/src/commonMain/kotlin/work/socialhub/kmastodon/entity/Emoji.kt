package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Emoji {

    @SerialName("shortcode")
    var shortcode: String? = null

    @SerialName("static_url")
    var staticUrl: String? = null

    @SerialName("url")
    var url: String? = null

    @SerialName("visible_in_picker")
    var visibleInPicker: Boolean? = null

    @SerialName("category")
    var category: String? = null
}
