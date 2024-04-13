package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.apps.AppsRegisterApplicationRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthAuthorizationUrlRequest
import work.socialhub.kmastodon.api.request.oauth.OAuthIssueAccessTokenWithAuthorizationCodeRequest
import kotlin.test.Test

class OAuthTest : AbstractTest() {

    @Test
    fun testCreateApp() {
        val response = mastodon().apps().registerApplication(
            AppsRegisterApplicationRequest().also {
                it.name = "kmastodon (test)"
                it.website = "https://github.com/uakihir0/kmastodon"
                it.redirectUris = "http://localhost:8080/"
                it.scopes = "read write follow push"
            }
        )
        println(response.data.id)
        println(response.data.clientId)
        println(response.data.clientSecret)
        println(response.data.redirectUri)
    }

    @Test
    fun testAuthorizationUrl() {
        val response = mastodon().oauth().authorizationUrl(
            OAuthAuthorizationUrlRequest().also {
                it.clientId = CLIENT_ID
                it.redirectUri = "http://localhost:8080/"
                it.scopes = "read write follow push"
            }
        )

        println(response.data)
    }


    @Test
    fun testIssueAccessTokenWithCredentials() {
        val response = mastodon().oauth().issueAccessTokenWithAuthorizationCode(
            OAuthIssueAccessTokenWithAuthorizationCodeRequest().also {
                it.clientId = CLIENT_ID
                it.clientSecret = CLIENT_SECRET
                it.redirectUri = "http://localhost:8080/"
                it.code = "xhHV4hZs0jB-wtnS3IfCy5_ixLYF7fjlt8JYRl-uKNw"
            }
        )

        println(response.data.accessToken)
        println(response.data.tokenType)
        println(response.data.scope)
    }
}