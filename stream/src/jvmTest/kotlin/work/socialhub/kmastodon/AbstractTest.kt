package work.socialhub.kmastodon

import kotlinx.serialization.json.Json
import work.socialhub.kmastodon.domain.Service
import java.io.File
import kotlin.test.BeforeTest

abstract class AbstractTest {

    companion object {
        var HOST: String? = null
        var CLIENT_ID: String? = null
        var CLIENT_SECRET: String? = null
        var USER_TOKEN: String? = null
        var SERVICE: Service = Service.MASTODON
    }

    protected val json = Json {
        ignoreUnknownKeys = true
    }

    fun mastodon(): Mastodon {
        return MastodonFactory.instance(
            HOST!!, USER_TOKEN!!, SERVICE
        )
    }

    @BeforeTest
    fun setupTest() {

        try {
            // Get credentials from environment variables.
            HOST = System.getenv("MASTODON_HOST")
                ?: System.getProperty("MASTODON_HOST")
            CLIENT_ID = System.getenv("MASTODON_CLIENT_ID")
                ?: System.getProperty("MASTODON_CLIENT_ID")
            CLIENT_SECRET = System.getenv("MASTODON_CLIENT_SECRET")
                ?: System.getProperty("MASTODON_CLIENT_SECRET")
            USER_TOKEN = System.getenv("MASTODON_USER_TOKEN")
                ?: System.getProperty("MASTODON_USER_TOKEN")

            val serviceName = System.getenv("MASTODON_SERVICE")
                ?: System.getProperty("MASTODON_SERVICE")
            if (!serviceName.isNullOrEmpty()) {
                SERVICE = Service.from(serviceName)
            }
        } catch (_: Exception) {
        }

        if (HOST == null || USER_TOKEN == null) {
            try {
                // Get credentials from secrets.json file.
                readTestProps()?.get("mastodon")?.let {
                    HOST = it["MASTODON_HOST"]
                    CLIENT_ID = it["MASTODON_CLIENT_ID"]
                    CLIENT_SECRET = it["MASTODON_CLIENT_SECRET"]
                    USER_TOKEN = it["MASTODON_USER_TOKEN"]

                    val serviceName = it["MASTODON_SERVICE"]
                    if (!serviceName.isNullOrEmpty()) {
                        SERVICE = Service.from(serviceName)
                    }
                }
            } catch (_: Exception) {
            }
        }

        if (HOST == null || USER_TOKEN == null) {
            throw IllegalStateException(
                """!!!
                No credentials exist for testing.
                Set the environment variables MASTODON_HOST and MASTODON_USER_TOKEN
                or copy the following file and describe its contents.
                `cp secrets.json.default secrets.json`
                !!!""".trimIndent()
            )
        }
    }

    /**
     * Read Test Properties
     */
    private fun readTestProps(): Map<String, Map<String, String>>? {
        return try {
            val jsonStr = File("../secrets.json").readText()
            json.decodeFromString<Map<String, Map<String, String>>>(jsonStr)
        } catch (e: Exception) {
            null
        }
    }
}
