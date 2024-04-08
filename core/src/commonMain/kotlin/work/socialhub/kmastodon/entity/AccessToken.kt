package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author hecateball
 */
class AccessToken : java.io.Serializable {
    @SerializedName("access_token")
    var accessToken: String? = null

    @SerializedName("token_type")
    var tokenType: String? = null

    @SerializedName("scope")
    var scope: String? = null

    @SerializedName("created_at")
    var createdAt: Long = 0

    // PixelFed
    @SerializedName("refresh_token")
    var refreshToken: String? = null

    @SerializedName("expires_in")
    var expiresIn: Long? = null
}
