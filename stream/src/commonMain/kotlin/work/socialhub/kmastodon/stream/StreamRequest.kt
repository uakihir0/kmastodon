package work.socialhub.kmastodon.stream

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class StreamRequest {
    var type: String? = null
    var stream: String? = null
    var list: String? = null
    var tag: String? = null

    @SerialName("access_token")
    var accessToken: String? = null
}