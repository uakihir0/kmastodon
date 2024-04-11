package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.oauth.OAuthAuthorizationUrlRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthIssueAccessTokenWithAuthorizationCodeRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthIssueAccessTokenWithCredentialsRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthRefreshAccessTokenRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.oauth.OAuthAuthorizationUrlResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthIssueAccessTokenWithAuthorizationCodeResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthIssueAccessTokenWithCredentialsResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthRefreshAccessTokenResponse
import kotlin.js.JsExport

@JsExport
interface OAuthResource {

    /**
     * Attempt to log in with the given credentials,
     * and then retrieve the access token for the current user.
     */
    fun issueAccessTokenWithCredentials(
        request: OAuthIssueAccessTokenWithCredentialsRequest
    ): Response<OAuthIssueAccessTokenWithCredentialsResponse>

    /**
     * Attempt to log in with authorization code,
     * and then retrieve the access token for the current user.
     */
    fun issueAccessTokenWithAuthorizationCode(
        request: OAuthIssueAccessTokenWithAuthorizationCodeRequest
    ): Response<OAuthIssueAccessTokenWithAuthorizationCodeResponse>

    /**
     * Attempt to renew access token with refresh token,
     * and then retrieve new access token for the current user.
     */
    fun refreshAccessToken(
        request: OAuthRefreshAccessTokenRequest
    ): Response<OAuthRefreshAccessTokenResponse>

    /**
     * Get Authorization URL
     */
    fun authorizationUrl(
        request: OAuthAuthorizationUrlRequest
    ): Response<OAuthAuthorizationUrlResponse>
}
