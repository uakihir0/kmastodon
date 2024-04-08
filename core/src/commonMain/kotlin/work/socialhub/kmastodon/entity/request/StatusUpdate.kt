package work.socialhub.kmastodon.entity.request

class StatusUpdate {
    var inReplyToId: String? = null

    var sensitive: Boolean? = null

    var spoilerText: String? = null

    var visibility: String? = null

    var status: String? = null

    var content: String? = null

    var mediaIds: List<String>? = null

    var pollOptions: List<String>? = null

    var pollExpiresIn: Long? = null

    var pollMultiple: Boolean? = null

    var pollHideTotals: Boolean? = null
}
