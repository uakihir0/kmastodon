package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author uakihir0
 */
public class Subscription implements Serializable {

    @SerializedName("id")
    private Long id;
    @SerializedName("endpoint")
    private String endpoint;
    @SerializedName("alerts")
    private Alert alerts;
    @SerializedName("server_key")
    private String serverKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Alert getAlerts() {
        return alerts;
    }

    public void setAlerts(Alert alerts) {
        this.alerts = alerts;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }
}

