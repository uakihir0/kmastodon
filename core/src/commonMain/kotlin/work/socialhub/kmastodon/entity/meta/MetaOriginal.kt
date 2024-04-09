package work.socialhub.kmastodon.entity.meta

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class MetaOriginal {

    var width: Int = 0
    var height: Int = 0
    var size: String? = null
    var aspect: Float = 0f
}
