package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class Emoji {

    @SerializedName("shortcode")
    private String shortcode;
    @SerializedName("static_url")
    private String staticUrl;
    @SerializedName("url")
    private String url;
    @SerializedName("visible_in_picker")
    private Boolean visibleInPicker;
    // Nullable
    @SerializedName("category")
    private String category;

    // region
    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getVisibleInPicker() {
        return visibleInPicker;
    }

    public void setVisibleInPicker(Boolean visibleInPicker) {
        this.visibleInPicker = visibleInPicker;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // endregion
}
