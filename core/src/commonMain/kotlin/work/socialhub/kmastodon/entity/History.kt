package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class History {
    var day: String? = null
    var uses: Int? = null
    var accounts: Int? = null
}
