package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class AccountSource {

    var privacy: String? = null
    var sensitive: Boolean? = null
    var language: String? = null
    var note: String? = null
    var fields: Array<Field>? = null
}
