package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1Configuration {

    @SerialName("statuses")
    lateinit var statuses: InstanceV1Statuses

    @SerialName("media_attachments")
    lateinit var mediaAttachments: InstanceV1MediaAttachments

    @SerialName("polls")
    lateinit var polls: InstanceV1Polls
}