package work.socialhub.kmastodon.api.request.oauth

import kotlin.js.JsExport

@JsExport
class OAuthAuthorizationUrlRequest {
    var clientId: String? = null
    var redirectUri: String? = null
    var scopes: String? = null
}