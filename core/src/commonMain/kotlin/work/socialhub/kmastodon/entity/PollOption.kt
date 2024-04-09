package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class PollOption {

    @SerialName("title")
    var title: String? = null

    @SerialName("votes_count")
    var votesCount: Int? = null
}