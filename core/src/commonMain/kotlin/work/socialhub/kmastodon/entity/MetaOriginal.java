package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class MetaOriginal {

    @SerializedName("width")
    private long width;
    @SerializedName("height")
    private long height;
    @SerializedName("size")
    private String size;
    @SerializedName("aspect")
    private float aspect;

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getAspect() {
        return aspect;
    }

    public void setAspect(float aspect) {
        this.aspect = aspect;
    }
}
