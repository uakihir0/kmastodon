package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class MetaOriginal {
    @SerializedName("width")
    var width: Long = 0

    @SerializedName("height")
    var height: Long = 0

    @SerializedName("size")
    var size: String? = null

    @SerializedName("aspect")
    var aspect: Float = 0f
}
