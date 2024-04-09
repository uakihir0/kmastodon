package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class Results {

    @SerialName("accounts")
    var accounts: Array<Account>? = null

    @SerialName("statuses")
    var statuses: Array<Status>? = null

    @SerialName("hashtags")
    var hashtags: Array<Tag>? = null
}
