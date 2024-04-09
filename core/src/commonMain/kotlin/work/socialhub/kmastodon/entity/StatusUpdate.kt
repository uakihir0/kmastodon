package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class StatusUpdate {

    var inReplyToId: String? = null

    var sensitive: Boolean? = null

    var spoilerText: String? = null

    var visibility: String? = null

    var status: String? = null

    var content: String? = null

    var mediaIds: Array<String>? = null

    var pollOptions: Array<String>? = null

    var pollExpiresIn: Int? = null

    var pollMultiple: Boolean? = null

    var pollHideTotals: Boolean? = null
}
