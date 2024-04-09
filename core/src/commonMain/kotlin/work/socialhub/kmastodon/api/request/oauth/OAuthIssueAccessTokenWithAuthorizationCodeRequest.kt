package work.socialhub.kmastodon.api.request.oauth

import kotlin.js.JsExport

@JsExport
class OAuthIssueAccessTokenWithAuthorizationCodeRequest {
    var clientId: String? = null
    var clientSecret: String? = null
    var redirectUri: String? = null
    var code: String? = null
}