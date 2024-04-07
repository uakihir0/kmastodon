package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author uakihir0
 */
public class Conversation implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("accounts")
    private Account[] accounts;
    @SerializedName("last_status")
    private Status lastStatus;
    @SerializedName("unread")
    private Boolean unread;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Status getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(Status lastStatus) {
        this.lastStatus = lastStatus;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }
}
