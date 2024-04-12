package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Role {
    var id: Int = -1
    lateinit var name: String
    lateinit var color: String
    var permissions: Int = -1

    @SerialName("highlighted")
    var isHighlighted: Boolean = false
}