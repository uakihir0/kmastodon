package work.socialhub.kmastodon.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author uakihir0
 */
public class NodeInfo {

    @SerializedName("links")
    private List<Links> links;

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public static class Links {

        @SerializedName("href")
        private String href;
        @SerializedName("rel")
        private String rel;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }
    }
}


