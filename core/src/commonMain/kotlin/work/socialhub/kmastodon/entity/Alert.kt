package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Alert : java.io.Serializable {
    @SerializedName("follow")
    var follow: Boolean? = null

    @SerializedName("favourite")
    var favourite: Boolean? = null

    @SerializedName("reblog")
    var reblog: Boolean? = null

    @SerializedName("mention")
    var mention: Boolean? = null

    @SerializedName("poll")
    var poll: Boolean? = null

    @SerializedName("status")
    var status: Boolean? = null
}
