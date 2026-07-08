package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.internal.MastodonImpl
import work.socialhub.kmastodon.internal.PixelfedImpl
import work.socialhub.kmastodon.internal.PleromaImpl
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

    /**
     * get a Pleroma / Akkoma client, exposing Pleroma-specific resources
     * (emoji reactions, chats, ...) in addition to the Mastodon API.
     */
    fun pleroma(
        uri: String,
        accessToken: String = "",
        service: Service? = Service.PLEROMA,
    ): Pleroma {
        return PleromaImpl(uri, accessToken, service)
    }

    /**
     * get a Pixelfed client, exposing Pixelfed-specific resources
     * (stories, collections) in addition to the Mastodon API.
     */
    fun pixelfed(
        uri: String,
        accessToken: String = "",
        service: Service? = Service.PIXELFED,
    ): Pixelfed {
        return PixelfedImpl(uri, accessToken, service)
    }
}
