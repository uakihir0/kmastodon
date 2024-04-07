package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class Meta {

    @SerializedName("focus")
    private MetaFocus focus;
    @SerializedName("original")
    private MetaOriginal original;

    public MetaFocus getFocus() {
        return focus;
    }

    public void setFocus(MetaFocus focus) {
        this.focus = focus;
    }

    public MetaOriginal getOriginal() {
        return original;
    }

    public void setOriginal(MetaOriginal original) {
        this.original = original;
    }
}
