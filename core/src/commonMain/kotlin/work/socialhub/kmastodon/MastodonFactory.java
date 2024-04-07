package work.socialhub.kmastodon;

import mastodon4j.domain.Service;
import mastodon4j.internal._Mastodon;

/**
 * @author hecateball
 */
public final class MastodonFactory {

    private MastodonFactory() {
    }

    /**
     * get request instance without service.
     */
    public static Mastodon getInstance(String uri, String accessToken) {
        return new _Mastodon(null, uri, accessToken);
    }

    /**
     * get request instance with service.
     */
    public static Mastodon getInstance(Service service, String uri, String accessToken) {
        return new _Mastodon(service, uri, accessToken);
    }
}
