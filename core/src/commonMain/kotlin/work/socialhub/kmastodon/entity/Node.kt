package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

/**
 * @author uakihir0
 */
class Node {
    @SerializedName("version")
    var version: String? = null

    @SerializedName("software")
    var software: Software? = null

    @SerializedName("protocols")
    var protocols: AccountList<String>? = null

    @SerializedName("openRegistrations")
    var openRegistrations: Boolean? = null

    class Software {
        @SerializedName("name")
        var name: String? = null

        @SerializedName("version")
        var version: String? = null
    }

    class Usage {
        @SerializedName("users")
        var users: Users? = null

        @SerializedName("localPosts")
        var localPosts: Long? = null
    }

    class Users {
        @SerializedName("total")
        var total: Long? = null

        @SerializedName("activeMonth")
        var activeMonth: Long? = null

        @SerializedName("activeHalfyear")
        var activeHalfyear: Long? = null
    }
}
