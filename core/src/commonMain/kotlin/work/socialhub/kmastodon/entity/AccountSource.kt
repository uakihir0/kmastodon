package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author u_akihir0
 */
class AccountSource {
    @SerializedName("privacy")
    var privacy: String? = null

    @SerializedName("sensitive")
    var sensitive: Boolean? = null

    @SerializedName("language")
    var language: String? = null

    @SerializedName("note")
    var note: String? = null

    @SerializedName("fields")
    var fields: Array<Field>
}
