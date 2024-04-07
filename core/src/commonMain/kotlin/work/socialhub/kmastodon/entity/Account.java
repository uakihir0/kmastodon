package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;
import mastodon4j.entity.pleroma.PleromaAccount;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Account implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String userName;
    @SerializedName("acct")
    private String account;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("locked")
    private boolean locked;
    @SerializedName("bot")
    private Boolean bot;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("followers_count")
    private long followersCount;
    @SerializedName("following_count")
    private long followingCount;
    @SerializedName("statuses_count")
    private long statusesCount;
    @SerializedName("note")
    private String note;
    @SerializedName("url")
    private String url;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("avatar_static")
    private String avatarStatic;
    @SerializedName("header")
    private String header;
    @SerializedName("header_static")
    private String headerStatic;
    @SerializedName("emojis")
    private Emoji[] emojis;
    @SerializedName("source")
    private AccountSource source;
    @SerializedName("fields")
    private Field[] fields;

    // Pleroma
    @SerializedName("pleroma")
    private PleromaAccount pleroma;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(long followingCount) {
        this.followingCount = followingCount;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarStatic() {
        return avatarStatic;
    }

    public void setAvatarStatic(String avatarStatic) {
        this.avatarStatic = avatarStatic;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeaderStatic() {
        return headerStatic;
    }

    public void setHeaderStatic(String headerStatic) {
        this.headerStatic = headerStatic;
    }

    public Boolean getBot() {
        return bot;
    }

    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    public Emoji[] getEmojis() {
        return emojis;
    }

    public void setEmojis(Emoji[] emojis) {
        this.emojis = emojis;
    }

    public AccountSource getSource() {
        return source;
    }

    public void setSource(AccountSource source) {
        this.source = source;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public PleromaAccount getPleroma() {
        return pleroma;
    }

    public void setPleroma(PleromaAccount pleroma) {
        this.pleroma = pleroma;
    }
}
