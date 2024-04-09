package work.socialhub.kmastodon.api.request.oauth

import kotlin.js.JsExport

@JsExport
class OAuthRefreshAccessTokenRequest {
    var clientId: String? = null
    var clientSecret: String? = null
    var refreshToken: String? = null
}