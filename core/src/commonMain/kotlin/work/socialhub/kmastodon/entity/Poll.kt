package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Poll {

    @SerialName("id")
    var id: String? = null

    @SerialName("expires_at")
    var expiresAt: String? = null

    @SerialName("expired")
    var isExpired: Boolean = false

    @SerialName("multiple")
    var isMultiple: Boolean = false

    @SerialName("voted")
    var isVoted: Boolean = false

    @SerialName("own_votes")
    var ownVotes: Array<Int>? = null

    @SerialName("votes_count")
    var votesCount: Int? = null

    @SerialName("voters_count")
    var votersCount: Int? = null

    @SerialName("options")
    var options: Array<PollOption>? = null

    @SerialName("emojis")
    var emojis: Array<Emoji>? = null
}