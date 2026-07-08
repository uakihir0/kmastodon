package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.entity.Account
import kotlin.js.JsExport

@JsExport
@Serializable
class PleromaReaction {

    @SerialName("count")
    var count: Int = 0

    @SerialName("me")
    var isMe: Boolean = false

    @SerialName("name")
    var name: String? = null

    /** Pleroma: full accounts that reacted. */
    @SerialName("accounts")
    var accounts: Array<Account>? = null

    /** Akkoma 3.2+: ids of accounts that reacted (instead of full accounts). */
    @SerialName("account_ids")
    var accountIds: Array<String>? = null
}
