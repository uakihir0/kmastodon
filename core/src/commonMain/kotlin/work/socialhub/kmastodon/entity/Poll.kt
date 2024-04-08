package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Poll {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("expires_at")
    var expiresAt: String? = null

    @SerializedName("expired")
    var isExpired: Boolean = false

    @SerializedName("multiple")
    var isMultiple: Boolean = false

    @SerializedName("voted")
    var isVoted: Boolean = false

    @SerializedName("own_votes")
    var ownVotes: Array<Long>

    @SerializedName("votes_count")
    var votesCount: Long? = null

    @SerializedName("voters_count")
    var votersCount: Long? = null

    @SerializedName("options")
    var options: Array<Option>

    @SerializedName("emojis")
    var emojis: Array<Emoji>

    class Option {
        @SerializedName("title")
        var title: String? = null

        @SerializedName("votes_count")
        var votesCount: Long? = null
    }
}