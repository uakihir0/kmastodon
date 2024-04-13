package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.oauth.OAuthAuthorizationUrlRequest
import kotlin.test.Test

class OAuthTest : AbstractTest() {

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
}