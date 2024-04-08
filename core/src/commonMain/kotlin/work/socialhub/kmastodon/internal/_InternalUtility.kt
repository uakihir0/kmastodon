package work.socialhub.kmastodon.internal

import com.google.gson.Gson
import mastodon4j.MastodonException
import mastodon4j.entity.Error
import mastodon4j.entity.share.Link
import mastodon4j.entity.share.RateLimit
import mastodon4j.entity.share.Response
import net.socialhub.http.HttpException
import net.socialhub.http.HttpRequestBuilder
import net.socialhub.http.HttpResponse
import net.socialhub.http.HttpResponseCode

/**
 * @author hecateball
 */
internal object _InternalUtility {
    private val gson: Gson = Gson()

    fun getBearerToken(accessToken: String): String {
        return "Bearer $accessToken"
    }

    val gsonInstance: Gson
        get() = gson

    fun proceed(function: RequestInterface<*>): Response<java.lang.Void> {
        try {
            val response: HttpResponse = function.proceed()
            when (response.getStatusCode()) {
                HttpResponseCode.OK -> {
                    val result: Response<java.lang.Void> = Response()
                    result.setRateLimit(RateLimit.of(response))
                    return result
                }

                else -> {
                    val error: java.lang.Error = gson.fromJson(response.asString(), java.lang.Error::class.java)
                    throw MastodonException(error, response.getStatusCode())
                }
            }
        } catch (e: HttpException) {
            throw MastodonException(e)
        }
    }

    fun <T> proceed(clazz: java.lang.Class<T>?, function: RequestInterface<*>): Response<T> {
        try {
            val response: HttpResponse = function.proceed()
            when (response.getStatusCode()) {
                HttpResponseCode.OK -> {
                    val result: Response<T> = Response()
                    result.set(gson.fromJson(response.asString(), clazz))
                    result.setRateLimit(RateLimit.of(response))
                    result.setLink(Link.of(response))
                    return result
                }

                else -> {
                    val error: java.lang.Error = gson.fromJson(response.asString(), java.lang.Error::class.java)
                    throw MastodonException(error, response.getStatusCode())
                }
            }
        } catch (e: HttpException) {
            throw MastodonException(e)
        }
    }

    fun addParam(builder: HttpRequestBuilder, key: String?, value: Any?) {
        if (value != null) {
            builder.param(key, value.toString())
        }
    }

    fun encode(str: String): String {
        return try {
            java.net.URLEncoder.encode(str, "utf-8")
        } catch (e: java.lang.Exception) {
            str
        }
    }

    internal interface RequestInterface<T> {
        @Throws(HttpException::class)
        fun proceed(): HttpResponse
    }
}
