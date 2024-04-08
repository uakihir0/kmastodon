package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Error : java.io.Serializable {
    @SerializedName("error")
    var error: String? = null

    @SerializedName("error_description")
    var description: String? = null
}
