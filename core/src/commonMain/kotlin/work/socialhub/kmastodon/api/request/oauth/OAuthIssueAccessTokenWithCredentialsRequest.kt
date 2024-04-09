package work.socialhub.kmastodon.api.request.oauth

import kotlin.js.JsExport

@JsExport
class OAuthIssueAccessTokenWithCredentialsRequest {
    var clientId: String? = null
    var clientSecret: String? = null
    var emailAddress: String? = null
    var password: String? = null
    var scopes: String? = null

}