package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author uakihir0
 */
public class Node {

    @SerializedName("version")
    private String version;
    @SerializedName("software")
    private Software software;
    @SerializedName("protocols")
    private List<String> protocols;
    @SerializedName("openRegistrations")
    private Boolean openRegistrations;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public List<String> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    public Boolean getOpenRegistrations() {
        return openRegistrations;
    }

    public void setOpenRegistrations(Boolean openRegistrations) {
        this.openRegistrations = openRegistrations;
    }

    public static class Software {
        @SerializedName("name")
        private String name;
        @SerializedName("version")
        private String version;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class Usage {
        @SerializedName("users")
        private Users users;
        @SerializedName("localPosts")
        private Long localPosts;

        public Users getUsers() {
            return users;
        }

        public void setUsers(Users users) {
            this.users = users;
        }

        public Long getLocalPosts() {
            return localPosts;
        }

        public void setLocalPosts(Long localPosts) {
            this.localPosts = localPosts;
        }
    }

    public static class Users {
        @SerializedName("total")
        private Long total;
        @SerializedName("activeMonth")
        private Long activeMonth;
        @SerializedName("activeHalfyear")
        private Long activeHalfyear;

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Long getActiveMonth() {
            return activeMonth;
        }

        public void setActiveMonth(Long activeMonth) {
            this.activeMonth = activeMonth;
        }

        public Long getActiveHalfyear() {
            return activeHalfyear;
        }

        public void setActiveHalfyear(Long activeHalfyear) {
            this.activeHalfyear = activeHalfyear;
        }
    }
}
