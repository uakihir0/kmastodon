package work.socialhub.kmastodon.entity.pleroma

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class PleromaReaction {
    @SerializedName("count")
    var count: Int = 0

    @SerializedName("me")
    var isMe: Boolean = false

    @SerializedName("name")
    var name: String? = null
}
