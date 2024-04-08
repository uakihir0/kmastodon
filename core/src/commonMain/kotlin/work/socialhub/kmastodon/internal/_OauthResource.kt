package work.socialhub.kmastodon.internal

import mastodon4j.api.OauthResource
import mastodon4j.entity.AccessToken
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpParameter
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _OauthResource(private val uri: String) : OauthResource {
    /**
     * {@inheritDoc}
     */
    fun issueAccessToken(
        clientId: String?,
        clientSecret: String?,
        emailAddress: String?,
        password: String?,
        scopes: String?
    ): Response<AccessToken> {
        return proceed(AccessToken::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/oauth/token")
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("username", emailAddress)
                .param("password", password)
                .param("scope", scopes)
                .param("grant_type", "password")
                .request(HttpMediaType.APPLICATION_JSON)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun issueAccessToken(
        clientId: String?,
        clientSecret: String?,
        redirectUri: String?,
        code: String?
    ): Response<AccessToken> {
        return proceed(AccessToken::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/oauth/token")
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("redirect_uri", redirectUri)
                .param("code", code)
                .param("grant_type", "authorization_code")
                .request(HttpMediaType.APPLICATION_JSON)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun refreshAccessToken(clientId: String?, clientSecret: String?, refreshToken: String?): Response<AccessToken> {
        return proceed(AccessToken::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/oauth/token")
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("refresh_token", refreshToken)
                .param("grant_type", "refresh_token")
                .request(HttpMediaType.APPLICATION_JSON)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getAuthorizationUrl(clientId: String?, redirectUri: String?, scopes: String?): String {
        val params: MutableList<HttpParameter> = java.util.ArrayList<HttpParameter>()
        params.add(HttpParameter("client_id", clientId))
        params.add(HttpParameter("response_type", "code"))
        params.add(HttpParameter("redirect_uri", redirectUri))
        params.add(HttpParameter("scope", scopes))

        return this.uri + "/oauth/authorize?" + HttpParameter.encodeParameters(params.toTypedArray())
    }
}
