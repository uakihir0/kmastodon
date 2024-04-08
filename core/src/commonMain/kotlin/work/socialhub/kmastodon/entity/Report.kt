package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Report : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("actionTaken")
    var actionTaken: String? = null
}
