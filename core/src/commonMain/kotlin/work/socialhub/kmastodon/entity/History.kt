package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class History : java.io.Serializable {
    @SerializedName("day")
    var day: String? = null

    @SerializedName("uses")
    var uses: Long? = null

    @SerializedName("accounts")
    var accounts: Long? = null
}
