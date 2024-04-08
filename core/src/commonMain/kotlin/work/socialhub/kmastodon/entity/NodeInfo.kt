package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class NodeInfo {
    @SerializedName("links")
    var links: List<Links>? = null

    class Links {
        @SerializedName("href")
        var href: String? = null

        @SerializedName("rel")
        var rel: String? = null
    }
}


