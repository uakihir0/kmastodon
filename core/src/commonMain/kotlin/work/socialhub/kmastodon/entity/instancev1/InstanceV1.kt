package work.socialhub.kmastodon.entity.instancev1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.Account
import kotlin.js.JsExport

@JsExport
@Serializable
class InstanceV1 {

    @SerialName("uri")
    var uri: String = ""

    @SerialName("title")
    var title: String = ""

    @SerialName("short_description")
    var shortDescription: String? = null

    @SerialName("description")
    var description: String = ""

    @SerialName("email")
    var email: String = ""

    @SerialName("version")
    var version: String = ""

    @SerialName("urls")
    var urls: InstanceV1Urls? = null

    @SerialName("stats")
    var stats: InstanceV1Stats? = null

    @SerialName("thumbnail")
    var thumbnail: String? = null

    @SerialName("languages")
    var languages: Array<String>? = null

    @SerialName("registrations")
    var registrations: Boolean? = null

    @SerialName("approval_required")
    var approvalRequired: Boolean? = null

    @SerialName("invites_enabled")
    var invitesEnabled: Boolean? = null

    @SerialName("configuration")
    var configuration: InstanceV1Configuration? = null

    @SerialName("contact_account")
    var contactAccount: Account? = null

    @SerialName("rules")
    var rules: Array<InstanceV1Rules>? = null
}