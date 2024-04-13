package work.socialhub.kmastodon.internal

import io.ktor.http.*
import io.ktor.http.URLProtocol.Companion.HTTPS
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.OAuthResource
import work.socialhub.kmastodon.api.request.oauth.OAuthAuthorizationUrlRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthIssueAccessTokenWithAuthorizationCodeRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthIssueAccessTokenWithCredentialsRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthRefreshAccessTokenRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.oauth.OAuthAuthorizationUrlResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthIssueAccessTokenWithAuthorizationCodeResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthIssueAccessTokenWithCredentialsResponse
import work.socialhub.kmastodon.api.response.oauth.OAuthRefreshAccessTokenResponse
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmpcommon.runBlocking

class OAuthResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    OAuthResource {

    /**
     * {@inheritDoc}
     */
    override fun issueAccessTokenWithCredentials(
        request: OAuthIssueAccessTokenWithCredentialsRequest
    ): Response<OAuthIssueAccessTokenWithCredentialsResponse> = exec {
        HttpRequest()
            .url("${uri}/oauth/token")
            .pwn("client_id", request.clientId)
            .pwn("client_secret", request.clientSecret)
            .pwn("username", request.emailAddress)
            .pwn("password", request.password)
            .pwn("scope", request.scopes)
            .pwn("grant_type", "password")
            .accept(MediaType.JSON)
            .post()
    }

    /**
     * {@inheritDoc}
     */
    override fun issueAccessTokenWithAuthorizationCode(
        request: OAuthIssueAccessTokenWithAuthorizationCodeRequest
    ): Response<OAuthIssueAccessTokenWithAuthorizationCodeResponse> = exec {
        HttpRequest()
            .url("${uri}/oauth/token")
            .pwn("client_id", request.clientId)
            .pwn("client_secret", request.clientSecret)
            .pwn("redirect_uri", request.redirectUri)
            .pwn("code", request.code)
            .pwn("grant_type", "authorization_code")
            .accept(MediaType.JSON)
            .post()
    }

    /**
     * {@inheritDoc}
     */
    override fun refreshAccessToken(
        request: OAuthRefreshAccessTokenRequest
    ): Response<OAuthRefreshAccessTokenResponse> = exec {
        HttpRequest()
            .url("${uri}/oauth/token")
            .pwn("client_id", request.clientId)
            .pwn("client_secret", request.clientSecret)
            .pwn("refresh_token", request.refreshToken)
            .pwn("grant_type", "refresh_token")
            .accept(MediaType.JSON)
            .post()
    }

    /**
     * {@inheritDoc}
     */
    override fun authorizationUrl(
        request: OAuthAuthorizationUrlRequest
    ): Response<OAuthAuthorizationUrlResponse> {
        return runBlocking {
            Response(
                URLBuilder().apply {
                    protocol = HTTPS
                    host = Url(uri).host
                    encodedPath = "/oauth/authorize"
                    parameters.append("response_type", "code")
                    parameters.append("client_id", request.clientId!!)
                    parameters.append("redirect_uri", request.redirectUri!!)
                    parameters.append("scope", request.scopes!!)
                }.buildString()
            )
        }
    }
}
