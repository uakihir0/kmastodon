package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author u_akihir0
 */
public class Field {

    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
