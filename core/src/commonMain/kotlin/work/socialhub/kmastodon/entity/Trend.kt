package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Trend {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("history")
    var history: Array<History>
}
