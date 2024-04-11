package work.socialhub.kmastodon.stream

import kotlinx.serialization.Serializable

@Serializable
class StreamResponse {
    var event: String? = null
    var payload: String? = null
    var stream: Array<String>? = null
}