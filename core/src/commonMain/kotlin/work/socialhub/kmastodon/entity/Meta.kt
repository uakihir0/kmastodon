package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Meta {
    @SerializedName("focus")
    var focus: MetaFocus? = null

    @SerializedName("original")
    var original: MetaOriginal? = null
}
