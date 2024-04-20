package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Polls {

    @SerialName("max_options")
    var maxOptions: Int = 0

    @SerialName("max_characters_per_option")
    var maxCharactersPerOption: Int = 0

    @SerialName("min_expiration")
    var minExpiration: Int = 0

    @SerialName("max_expiration")
    var maxExpiration: Int = 0
}