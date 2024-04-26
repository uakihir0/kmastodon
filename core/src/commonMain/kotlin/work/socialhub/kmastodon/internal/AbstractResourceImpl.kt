package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import work.socialhub.kmastodon.Mastodon
import work.socialhub.kmastodon.MastodonException
import work.socialhub.kmastodon.api.request.Range
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.entity.share.Link
import work.socialhub.kmastodon.entity.share.RateLimit
import work.socialhub.kmastodon.internal.InternalUtility.fromJson
import work.socialhub.kmpcommon.runBlocking

abstract class AbstractResourceImpl(
    val uri: String
) {

    inline fun <reified T> proceed(
        body: () -> HttpResponse
    ): Response<T> {
        try {
            val response = body()
            if (response.status == 200) {
                return Response(fromJson<T>(response.stringBody))
                    .also {
                        it.limit = RateLimit.of(response)
                        it.link = Link.of(response)
                        it.json = response.stringBody
                    }
            }
            throw MastodonException(
                response.status,
                response.stringBody
            )
        } catch (e: Exception) {
            throw e as? MastodonException
                ?: MastodonException(e)
        }
    }

    inline fun proceedUnit(
        body: () -> HttpResponse
    ): ResponseUnit {
        try {
            val response = body()
            if (response.status == 200) {
                return ResponseUnit().also {
                    it.limit = RateLimit.of(response)
                    it.link = Link.of(response)
                }
            }

            throw MastodonException(
                response.status,
                response.stringBody
            )
        } catch (e: Exception) {
            throw e as? MastodonException
                ?: MastodonException(e)
        }
    }

    fun HttpRequest.pwn(
        key: String,
        value: Any?,
    ): HttpRequest {
        if (value != null)
            param(key, value)
        return this
    }

    fun <T> HttpRequest.pwns(
        key: String,
        values: Array<T>?,
    ): HttpRequest {
        values?.forEach {
            param("${key}[]", it as Any)
        }
        return this
    }

    fun HttpRequest.qwn(
        key: String,
        value: Any?,
    ): HttpRequest {
        if (value != null)
            query(key, value)
        return this
    }

    fun <T> HttpRequest.qwns(
        key: String,
        values: Array<T>?,
    ): HttpRequest {
        values?.forEach {
            query("${key}[]", it as Any)
        }
        return this
    }

    fun HttpRequest.paging(
        range: Range?,
        service: Service
    ): HttpRequest {
        if (range != null) {

            // limit
            range.limit?.let {
                var limit = it
                if ((service === Service.PIXELFED) &&
                    (limit > AbstractAuthResourceImpl.PIXELFED_LIMIT_MAX)
                ) limit = AbstractAuthResourceImpl.PIXELFED_LIMIT_MAX
                param("limit", limit)
            }

            // since_id
            range.sinceId?.let { param("since_id", it) }

            // max_id
            range.maxId?.let { param("max_id", it) }

            // min_id
            range.minId?.let { param("min_id", it) }
        }

        return this
    }

    protected inline fun <reified T> exec(
        crossinline function: suspend () -> HttpResponse
    ): Response<T> {
        return runBlocking {
            proceed<T> { function() }
        }
    }

    protected inline fun unit(
        crossinline function: suspend () -> HttpResponse
    ): ResponseUnit {
        return runBlocking {
            proceedUnit { function() }
        }
    }
}