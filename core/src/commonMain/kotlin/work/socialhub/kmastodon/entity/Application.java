package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Application implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("website")
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
