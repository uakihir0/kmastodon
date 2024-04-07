package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class Tag implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("history")
    private History[] history;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public History[] getHistory() {
        return history;
    }

    public void setHistory(History[] history) {
        this.history = history;
    }
}
