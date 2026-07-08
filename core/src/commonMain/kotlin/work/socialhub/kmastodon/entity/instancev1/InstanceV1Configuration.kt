package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Configuration {

    @SerialName("statuses")
    var statuses: InstanceV1Statuses? = null

    @SerialName("media_attachments")
    var mediaAttachments: InstanceV1MediaAttachments? = null

    @SerialName("polls")
    var polls: InstanceV1Polls? = null
}