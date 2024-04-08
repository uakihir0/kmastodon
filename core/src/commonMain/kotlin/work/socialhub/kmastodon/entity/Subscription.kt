package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Subscription : java.io.Serializable {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("endpoint")
    var endpoint: String? = null

    @SerializedName("alerts")
    var alerts: Alert? = null

    @SerializedName("server_key")
    var serverKey: String? = null
}

