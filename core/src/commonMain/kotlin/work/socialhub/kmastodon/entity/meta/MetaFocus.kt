package work.socialhub.kmastodon.entity.meta

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class MetaFocus {
    var x: Float = 0f
    var y: Float = 0f
}
