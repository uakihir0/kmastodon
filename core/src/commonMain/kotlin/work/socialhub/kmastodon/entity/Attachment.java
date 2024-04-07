package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Attachment implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("remote_url")
    private String remoteUrl;
    @SerializedName("preview_url")
    private String previewUrl;
    @SerializedName("text_url")
    private String textUrl;

    // for PixelFed
    @SerializedName("optimized_url")
    private String optimizedUrl;
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("orientation")
    private String orientation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getTextUrl() {
        return textUrl;
    }

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    // for PixelFed

    public String getOptimizedUrl() {
        return optimizedUrl;
    }

    public void setOptimizedUrl(String optimizedUrl) {
        this.optimizedUrl = optimizedUrl;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
