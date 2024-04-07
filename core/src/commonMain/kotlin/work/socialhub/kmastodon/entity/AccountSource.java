package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author u_akihir0
 */
public class AccountSource {

    @SerializedName("privacy")
    private String privacy;
    @SerializedName("sensitive")
    private Boolean sensitive;
    @SerializedName("language")
    private String language;
    @SerializedName("note")
    private String note;
    @SerializedName("fields")
    private Field[] fields;

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Boolean getSensitive() {
        return sensitive;
    }

    public void setSensitive(Boolean sensitive) {
        this.sensitive = sensitive;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }
}
