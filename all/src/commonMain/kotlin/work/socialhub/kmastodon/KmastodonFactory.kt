package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import kotlin.js.JsExport

@JsExport
object KmastodonFactory {

    fun instance(
        uri: String,
        userAccessToken: String = "",
        service: Service? = Service.MASTODON,
    ) = MastodonFactory
        .instance(uri, userAccessToken, service)

    fun pleroma(
        uri: String,
        userAccessToken: String = "",
        service: Service? = Service.PLEROMA,
    ) = MastodonFactory
        .pleroma(uri, userAccessToken, service)

    fun pixelfed(
        uri: String,
        userAccessToken: String = "",
        service: Service? = Service.PIXELFED,
    ) = MastodonFactory
        .pixelfed(uri, userAccessToken, service)
}