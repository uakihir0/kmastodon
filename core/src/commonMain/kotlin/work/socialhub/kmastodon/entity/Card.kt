package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Card {

    var url: String? = null
    var title: String? = null
    var description: String? = null
    var image: String? = null
}
