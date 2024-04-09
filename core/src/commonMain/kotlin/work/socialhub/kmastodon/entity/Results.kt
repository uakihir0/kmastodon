package work.socialhub.kmastodon.entity

import com.google.gson.annotations.SerializedName

class Results : java.io.Serializable {
    @SerializedName("accounts")
    var accounts: Array<Account>

    @SerializedName("statuses")
    var statuses: Array<Status>

    @SerializedName("hashtags")
    var hashtags: Array<Tag>
}
