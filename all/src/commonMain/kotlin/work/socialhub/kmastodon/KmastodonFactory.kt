package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import kotlin.js.JsExport

@JsExport
class KmastodonFactory {

    fun instance(
        uri: String,
        userAccessToken: String = "",
        service: Service = Service.MASTODON,
    ) = MastodonFactory
        .instance(uri, userAccessToken, service)
}