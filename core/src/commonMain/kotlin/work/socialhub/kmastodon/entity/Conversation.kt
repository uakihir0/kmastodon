package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Conversation : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("accounts")
    var accounts: Array<Account>

    @SerializedName("last_status")
    var lastStatus: Status? = null

    @SerializedName("unread")
    var unread: Boolean? = null
}
