package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class Poll {

    @SerializedName("id")
    private String id;
    @SerializedName("expires_at")
    private String expiresAt;

    @SerializedName("expired")
    private boolean expired;
    @SerializedName("multiple")
    private boolean multiple;
    @SerializedName("voted")
    private boolean voted;

    @SerializedName("own_votes")
    private Long[] ownVotes;
    @SerializedName("votes_count")
    private Long votesCount;
    @SerializedName("voters_count")
    private Long votersCount;

    @SerializedName("options")
    private Option[] options;
    @SerializedName("emojis")
    private Emoji[] emojis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public Long[] getOwnVotes() {
        return ownVotes;
    }

    public void setOwnVotes(Long[] ownVotes) {
        this.ownVotes = ownVotes;
    }

    public Long getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Long votesCount) {
        this.votesCount = votesCount;
    }

    public Long getVotersCount() {
        return votersCount;
    }

    public void setVotersCount(Long votersCount) {
        this.votersCount = votersCount;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public Emoji[] getEmojis() {
        return emojis;
    }

    public void setEmojis(Emoji[] emojis) {
        this.emojis = emojis;
    }

    public static class Option {

        @SerializedName("title")
        private String title;
        @SerializedName("votes_count")
        private Long votesCount;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getVotesCount() {
            return votesCount;
        }

        public void setVotesCount(Long votesCount) {
            this.votesCount = votesCount;
        }
    }
}