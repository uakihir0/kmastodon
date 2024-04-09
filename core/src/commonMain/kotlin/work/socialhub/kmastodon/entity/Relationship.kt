package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Relationship {

    @SerialName("id")
    var id: String? = null

    @SerialName("following")
    var isFollowing: Boolean = false

    @SerialName("followedBy")
    var isFollowedBy: Boolean = false

    @SerialName("blocking")
    var isBlocking: Boolean = false

    @SerialName("muting")
    var isMuting: Boolean = false

    @SerialName("requested")
    var isRequested: Boolean = false
}
