package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author u_akihir0
 */
class Field {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("value")
    var value: String? = null
}
