package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Application : java.io.Serializable {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("website")
    var website: String? = null
}
