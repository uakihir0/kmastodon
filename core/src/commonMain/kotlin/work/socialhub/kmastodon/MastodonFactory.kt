package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.internal.MastodonImpl
import kotlin.js.JsExport

@JsExport
object MastodonFactory {

    /**
     * get request instance
     */
    fun instance(
        uri: String,
        accessToken: String = "",
        service: Service = Service.MASTODON,
    ): Mastodon {
        return MastodonImpl(uri, accessToken, service)
    }
}
