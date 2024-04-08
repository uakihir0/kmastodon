package work.socialhub.kmastodon.api

import mastodon4j.entity.AccessToken
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface OauthResource {
    /**
     * Attempt to login with the given credentials, and then retrieve the access token for the current user.
     *
     * @param clientId
     * @param clientSecret
     * @param emailAddress
     * @param password
     * @param scopes
     * @return an AccessToken
     */
    fun issueAccessToken(
        clientId: String?,
        clientSecret: String?,
        emailAddress: String?,
        password: String?,
        scopes: String?
    ): Response<AccessToken?>?

    /**
     * Attempt to login with authorization code, and then retrieve the access token for the current user.
     *
     * @param clientId
     * @param clientSecret
     * @param redirectUri
     * @param code
     * @return an AccessToken
     */
    fun issueAccessToken(
        clientId: String?,
        clientSecret: String?,
        redirectUri: String?,
        code: String?
    ): Response<AccessToken?>?

    /**
     * Attempt to renew access token with refresh token, and then retrieve new access token for the current user.
     *
     * @param clientId
     * @param clientSecret
     * @param refreshToken
     * @param refreshToken
     * @return an AccessToken
     */
    fun refreshAccessToken(clientId: String?, clientSecret: String?, refreshToken: String?): Response<AccessToken?>?

    /**
     * Get Authorization URL
     *
     * @param clientId
     * @param redirectUri
     * @param scopes
     * @return an Authorization URL
     */
    fun getAuthorizationUrl(clientId: String?, redirectUri: String?, scopes: String?): String?
}
