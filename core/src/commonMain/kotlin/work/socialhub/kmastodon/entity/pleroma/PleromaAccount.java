package work.socialhub.kmastodon.entity.pleroma;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class PleromaAccount {

    @SerializedName("accepts_chat_messages")
    private boolean acceptsChatMessages;
    @SerializedName("allow_following_move")
    private boolean allowFollowingMove;
    @SerializedName("ap_id")
    private String apId;
    @SerializedName("background_image")
    private Object backgroundImage;
    @SerializedName("chat_token")
    private String chatToken;
    @SerializedName("email")
    private String email;
    @SerializedName("hide_favorites")
    private boolean hideFavorites;
    @SerializedName("hide_followers")
    private boolean hideFollowers;
    @SerializedName("hide_followers_count")
    private boolean hideFollowersCount;
    @SerializedName("hide_follows")
    private boolean hideFollows;
    @SerializedName("hide_follows_count")
    private boolean hideFollowsCount;
    @SerializedName("is_admin")
    private boolean isAdmin;
    @SerializedName("is_confirmed")
    private boolean isConfirmed;
    @SerializedName("is_moderator")
    private boolean isModerator;
    @SerializedName("skip_thread_containment")
    private boolean skipThreadContainment;
    @SerializedName("unread_conversation_count")
    private int unreadConversationCount;
    @SerializedName("unread_notifications_count")
    private int unreadNotificationsCount;

    public boolean isAcceptsChatMessages() {
        return acceptsChatMessages;
    }

    public void setAcceptsChatMessages(boolean acceptsChatMessages) {
        this.acceptsChatMessages = acceptsChatMessages;
    }

    public boolean isAllowFollowingMove() {
        return allowFollowingMove;
    }

    public void setAllowFollowingMove(boolean allowFollowingMove) {
        this.allowFollowingMove = allowFollowingMove;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public Object getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Object backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getChatToken() {
        return chatToken;
    }

    public void setChatToken(String chatToken) {
        this.chatToken = chatToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHideFavorites() {
        return hideFavorites;
    }

    public void setHideFavorites(boolean hideFavorites) {
        this.hideFavorites = hideFavorites;
    }

    public boolean isHideFollowers() {
        return hideFollowers;
    }

    public void setHideFollowers(boolean hideFollowers) {
        this.hideFollowers = hideFollowers;
    }

    public boolean isHideFollowersCount() {
        return hideFollowersCount;
    }

    public void setHideFollowersCount(boolean hideFollowersCount) {
        this.hideFollowersCount = hideFollowersCount;
    }

    public boolean isHideFollows() {
        return hideFollows;
    }

    public void setHideFollows(boolean hideFollows) {
        this.hideFollows = hideFollows;
    }

    public boolean isHideFollowsCount() {
        return hideFollowsCount;
    }

    public void setHideFollowsCount(boolean hideFollowsCount) {
        this.hideFollowsCount = hideFollowsCount;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }

    public boolean isSkipThreadContainment() {
        return skipThreadContainment;
    }

    public void setSkipThreadContainment(boolean skipThreadContainment) {
        this.skipThreadContainment = skipThreadContainment;
    }

    public int getUnreadConversationCount() {
        return unreadConversationCount;
    }

    public void setUnreadConversationCount(int unreadConversationCount) {
        this.unreadConversationCount = unreadConversationCount;
    }

    public int getUnreadNotificationsCount() {
        return unreadNotificationsCount;
    }

    public void setUnreadNotificationsCount(int unreadNotificationsCount) {
        this.unreadNotificationsCount = unreadNotificationsCount;
    }
}
