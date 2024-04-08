package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class NodeInfo {
    @SerializedName("links")
    var links: AccountList<Links>? = null

    class Links {
        @SerializedName("href")
        var href: String? = null

        @SerializedName("rel")
        var rel: String? = null
    }
}


