package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Notification : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("account")
    var account: Account? = null

    @SerializedName("status")
    var status: Status? = null
}
