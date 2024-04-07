package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author uakihir0
 */
public class MetaFocus {

    @SerializedName("x")
    private float x;
    @SerializedName("y")
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
