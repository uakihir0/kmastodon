package work.socialhub.kmastodon.entity.share;

import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;

import java.util.Arrays;

/**
 * @author uakihir0
 */
public class Link {

    private static final Logger logger = Logger.getLogger(Link.class);
    private static final String LINK = "link";

    private String nextUrl;
    private String prevUrl;

    private String nextMaxId;
    private String prevMinId;

    public static Link of(HttpResponse response) {
        if (response == null) {
            return null;
        }

        try {
            String header = response.getResponseHeader(LINK);
            if (header == null || header.isEmpty()) {
                return null;
            }

            // Next と Prev で分割
            String[] parts = header.split(",\\s?");

            Link link = new Link();
            for (String part : parts) {

                // リンクと rel で分割
                String[] elements = part.split(";\\s?");
                if (elements.length == 2) {

                    // Next
                    if (elements[1].contains("next")) {
                        String url = extractUrl(elements[0]);
                        if (!url.isEmpty()) {
                            link.setNextUrl(url);
                            link.setNextMaxId(extractValue(url, "max_id"));
                        }
                    }

                    // Prev
                    else if (elements[1].contains("prev")) {
                        String url = extractUrl(elements[0]);
                        if (!url.isEmpty()) {
                            link.setPrevUrl(url);
                            link.setPrevMinId(extractValue(url, "min_id"));
                        }
                    }
                }
            }
            return link;

        } catch (Exception e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    private static String extractUrl(String element) {
        return element.replaceAll("^\\s?<(.+)>\\s?$", "$1");
    }

    private static String extractValue(String url, String key) {
        String[] params = url.split("\\?")[1].split("&");

        return Arrays.stream(params)
                .map(e -> e.split("="))
                .filter(e -> e[0].equalsIgnoreCase(key))
                .map(e -> e[1])
                .findFirst()
                .orElse(null);
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    public void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }

    public String getPrevMinId() {
        return prevMinId;
    }

    public void setPrevMinId(String prevMinId) {
        this.prevMinId = prevMinId;
    }
}
