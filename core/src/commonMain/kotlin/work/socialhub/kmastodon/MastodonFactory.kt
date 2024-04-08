package work.socialhub.kmastodon

import mastodon4j.domain.Service
import mastodon4j.internal._Mastodon

/**
 * @author hecateball
 */
object MastodonFactory {
    /**
     * get request instance without service.
     */
    fun getInstance(uri: String?, accessToken: String?): Mastodon {
        return _Mastodon(null, uri, accessToken)
    }

    /**
     * get request instance with service.
     */
    fun getInstance(service: Service?, uri: String?, accessToken: String?): Mastodon {
        return _Mastodon(service, uri, accessToken)
    }
}
