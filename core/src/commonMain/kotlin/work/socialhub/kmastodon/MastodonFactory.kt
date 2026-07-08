package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.internal.MastodonImpl
import kotlin.js.JsExport

@JsExport
object MastodonFactory {

    /**
     * get request instance
     *
     * Pass `service = null` to auto-detect the instance software
     * (Mastodon, Pleroma, Akkoma, Pixelfed, GoToSocial, ...) via NodeInfo
     * on the first request. Defaults to [Service.MASTODON] for compatibility.
     */
    fun instance(
        uri: String,
        accessToken: String = "",
        service: Service? = Service.MASTODON,
    ): Mastodon {
        return MastodonImpl(uri, accessToken, service)
    }
}
