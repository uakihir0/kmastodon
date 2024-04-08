package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Emoji {
    // region
    @SerializedName("shortcode")
    var shortcode: String? = null

    @SerializedName("static_url")
    var staticUrl: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("visible_in_picker")
    var visibleInPicker: Boolean? = null

    // endregion
    // Nullable
    @SerializedName("category")
    var category: String? = null
}
