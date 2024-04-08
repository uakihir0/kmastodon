package work.socialhub.kmastodon.entity.pleroma

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class PleromaContent {
    @SerializedName("text/plain")
    var textPlain: String? = null
}
