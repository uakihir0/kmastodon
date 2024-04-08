package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class Context : java.io.Serializable {
    @SerializedName("ancestors")
    var ancestors: Array<Status>

    @SerializedName("descendants")
    var descendants: Array<Status>
}
