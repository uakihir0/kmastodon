package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Results implements Serializable {

    @SerializedName("accounts")
    private Account[] accounts;
    @SerializedName("statuses")
    private Status[] statuses;
    @SerializedName("hashtags")
    private Tag[] hashtags;

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Status[] getStatuses() {
        return statuses;
    }

    public void setStatuses(Status[] statuses) {
        this.statuses = statuses;
    }

    public Tag[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(Tag[] hashtags) {
        this.hashtags = hashtags;
    }

}
