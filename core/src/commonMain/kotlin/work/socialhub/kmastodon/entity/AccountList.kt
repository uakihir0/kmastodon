package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class AccountList : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("title")
    var title: String? = null
}
