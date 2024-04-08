package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class ClientCredential : java.io.Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("redirect_uri")
    var redirectUri: String? = null

    @SerializedName("client_id")
    var clientId: String? = null

    @SerializedName("client_secret")
    var clientSecret: String? = null
}
