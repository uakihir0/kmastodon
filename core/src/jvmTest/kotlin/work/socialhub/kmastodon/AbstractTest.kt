package work.socialhub.kmastodon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import java.io.FileReader
import kotlin.test.BeforeTest

open class AbstractTest {

    companion object {
        const val TEST_ACCOUNT_INDEX = 0

        var HOST: String? = null
        var CLIENT_ID: String? = null
        var CLIENT_SECRET: String? = null
        var USER_TOKEN: String? = null
        var OWNED_USER_TOKEN: String? = null
        var SERVICE: Service = Service.MASTODON
    }

    fun mastodon(): Mastodon {
        return MastodonFactory.instance(
            HOST!!, USER_TOKEN!!, SERVICE
        )
    }

    /**
     * Read File
     */
    private fun readFile(file: String): String {
        return FileReader(file).readText()
    }

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val json = readFile("../secrets.json")
            val props = fromJson<Secrets>(json)
            val param = props.params[TEST_ACCOUNT_INDEX]

            HOST = param.host
            CLIENT_ID = param.clientId
            CLIENT_SECRET = param.clientSecret
            USER_TOKEN = param.userToken
            OWNED_USER_TOKEN = param.ownedUserToken
            SERVICE = Service.from(param.service!!)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    @Serializable
    class Secrets {
        var params: List<SecretParams> = listOf()
    }

    @Serializable
    class SecretParams {
        var host: String? = null

        @SerialName("client_id")
        var clientId: String? = null

        @SerialName("client_secret")
        var clientSecret: String? = null

        @SerialName("user_token")
        var userToken: String? = null

        @SerialName("owned_user_token")
        var ownedUserToken: String? = null

        @SerialName("service")
        var service: String? = null
    }
}