package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author hecateball
 */
public class ClientCredential implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("redirect_uri")
    private String redirectUri;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
