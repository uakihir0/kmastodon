package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Relationship : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("following")
    var isFollowing: Boolean = false

    @SerializedName("followedBy")
    var isFollowedBy: Boolean = false

    @SerializedName("blocking")
    var isBlocking: Boolean = false

    @SerializedName("muting")
    var isMuting: Boolean = false

    @SerializedName("requested")
    var isRequested: Boolean = false
}
