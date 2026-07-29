package work.socialhub.kmastodon.entity.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Filter {

    var id: String? = null
    var title: String? = null
    var context: Array<String>? = null

    @SerialName("expires_at")
    var expiresAt: String? = null
    @SerialName("filter_action")
    var filterAction: String? = null

    var keywords: Array<FilterKeyword> = arrayOf()
    var statuses: Array<FilterStatus> = arrayOf()
}