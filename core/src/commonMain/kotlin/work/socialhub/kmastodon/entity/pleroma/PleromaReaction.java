package work.socialhub.kmastodon.entity.pleroma;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class PleromaReaction {

    @SerializedName("count")
    private int count;
    @SerializedName("me")
    private boolean me;
    @SerializedName("name")
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
