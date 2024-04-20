package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Polls {

    @SerialName("max_options")
    var maxOptions: Int? = null

    @SerialName("max_characters_per_option")
    var maxCharactersPerOption: Int? = null

    @SerialName("min_expiration")
    var minExpiration: Int? = null

    @SerialName("max_expiration")
    var maxExpiration: Int? = null
}