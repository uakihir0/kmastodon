package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Context {
    var ancestors: Array<Status>? = null
    var descendants: Array<Status>? = null
}
