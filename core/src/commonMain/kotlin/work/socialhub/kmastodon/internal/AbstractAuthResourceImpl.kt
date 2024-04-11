package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpResponse
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmpcommon.runBlocking

abstract class AbstractAuthResourceImpl(
    uri: String,
    val accessToken: String,
    val service: () -> Service = { Service.MASTODON },
) : AbstractResourceImpl(uri) {

    companion object {
        const val PIXELFED_LIMIT_MAX = 50
    }

    fun bearerToken(): String {
        return "Bearer $accessToken"
    }

    protected inline fun <reified T> exec(
        crossinline function: suspend () -> HttpResponse
    ): Response<T> {
        return runBlocking {
            proceed<T> { function() }
        }
    }
}