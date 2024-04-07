package work.socialhub.kmastodon.entity.pleroma;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class PleromaContent {

    @SerializedName("text/plain")
    private String textPlain;

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }
}
