package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Statuses {

    @SerialName("max_characters")
    var maxCharacters: Int = 0

    @SerialName("max_media_attachments")
    var maxMediaAttachments: Int = 0

    @SerialName("characters_reserved_per_url")
    var charactersReservedPerUrl: Int = 0
}