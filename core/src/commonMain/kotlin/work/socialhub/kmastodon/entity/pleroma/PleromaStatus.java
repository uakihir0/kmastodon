package work.socialhub.kmastodon.entity.pleroma;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author uakihir0
 */
public class PleromaStatus {

    @SerializedName("content")
    private PleromaContent content;
    @SerializedName("conversation_id")
    private int conversationId;
    @SerializedName("direct_conversation_id")
    private String directConversationId;
    @SerializedName("emoji_reactions")
    private List<PleromaReaction> emojiReactions;
    @SerializedName("expires_at")
    private String expiresAt;
    @SerializedName("in_reply_to_account_acct")
    private String inReplyToAccountAcct;
    @SerializedName("local")
    private boolean local;
    @SerializedName("parent_visible")
    private boolean parentVisible;
    @SerializedName("pinned_at")
    private String  pinnedAt;
    @SerializedName("spoiler_text")
    private PleromaContent spoilerText;
    @SerializedName("thread_muted")
    private boolean threadMuted;

    public PleromaContent getContent() {
        return content;
    }

    public void setContent(PleromaContent content) {
        this.content = content;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getDirectConversationId() {
        return directConversationId;
    }

    public void setDirectConversationId(String directConversationId) {
        this.directConversationId = directConversationId;
    }

    public List<PleromaReaction> getEmojiReactions() {
        return emojiReactions;
    }

    public void setEmojiReactions(List<PleromaReaction> emojiReactions) {
        this.emojiReactions = emojiReactions;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getInReplyToAccountAcct() {
        return inReplyToAccountAcct;
    }

    public void setInReplyToAccountAcct(String inReplyToAccountAcct) {
        this.inReplyToAccountAcct = inReplyToAccountAcct;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isParentVisible() {
        return parentVisible;
    }

    public void setParentVisible(boolean parentVisible) {
        this.parentVisible = parentVisible;
    }

    public String getPinnedAt() {
        return pinnedAt;
    }

    public void setPinnedAt(String pinnedAt) {
        this.pinnedAt = pinnedAt;
    }

    public PleromaContent getSpoilerText() {
        return spoilerText;
    }

    public void setSpoilerText(PleromaContent spoilerText) {
        this.spoilerText = spoilerText;
    }

    public boolean isThreadMuted() {
        return threadMuted;
    }

    public void setThreadMuted(boolean threadMuted) {
        this.threadMuted = threadMuted;
    }
}
