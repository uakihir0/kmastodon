package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV2Configuration {

    @SerialName("urls")
    lateinit var urls: InstanceV2Urls

    @SerialName("vapid")
    var vapid: InstanceV2Vapid? = null

    @SerialName("accounts")
    lateinit var accounts: InstanceV2Accounts

    @SerialName("statuses")
    lateinit var statuses: InstanceV2Statuses

    @SerialName("media_attachments")
    lateinit var mediaAttachments: InstanceV2MediaAttachments

    @SerialName("polls")
    lateinit var polls: InstanceV2Polls

    @SerialName("translation")
    lateinit var translation: InstanceV2Translation
}