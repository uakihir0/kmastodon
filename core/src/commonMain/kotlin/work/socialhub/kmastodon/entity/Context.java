package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Context implements Serializable {

    @SerializedName("ancestors")
    private Status[] ancestors;
    @SerializedName("descendants")
    private Status[] descendants;

    public Status[] getAncestors() {
        return ancestors;
    }

    public void setAncestors(Status[] ancestors) {
        this.ancestors = ancestors;
    }

    public Status[] getDescendants() {
        return descendants;
    }

    public void setDescendants(Status[] descendants) {
        this.descendants = descendants;
    }
}
