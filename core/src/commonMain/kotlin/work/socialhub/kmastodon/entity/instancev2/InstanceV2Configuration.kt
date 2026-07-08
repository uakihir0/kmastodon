package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Configuration {

    @SerialName("urls")
    var urls: InstanceV2Urls? = null

    @SerialName("vapid")
    var vapid: InstanceV2Vapid? = null

    @SerialName("accounts")
    var accounts: InstanceV2Accounts? = null

    @SerialName("statuses")
    var statuses: InstanceV2Statuses? = null

    @SerialName("media_attachments")
    var mediaAttachments: InstanceV2MediaAttachments? = null

    @SerialName("polls")
    var polls: InstanceV2Polls? = null

    @SerialName("translation")
    var translation: InstanceV2Translation? = null
}