package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Mention : java.io.Serializable {
    @SerializedName("url")
    var url: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("username")
    var userName: String? = null

    @SerializedName("acct")
    var account: String? = null
}
