package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.TimelinesResource
import mastodon4j.domain.Service
import mastodon4j.entity.Conversation
import mastodon4j.entity.Status
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.addParam
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder
import net.socialhub.http.HttpResponse

/**
 * @author hecateball
 */
internal class _TimelinesResource(
    service: java.util.function.Supplier<Service?>,
    private val uri: String,
    accessToken: String
) : TimelinesResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)
    private val service: java.util.function.Supplier<Service> = service

    fun getHomeTimeline(
        range: Range?
    ): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/timelines/home")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())
            var response: HttpResponse = builder.get()

            // 206 (Home feed is regenerating)
            for (i in 0..9) {
                if (response.getStatusCode() === 206) {
                    try {
                        java.lang.Thread.sleep(5000)
                    } catch (e: java.lang.InterruptedException) {
                        throw java.lang.RuntimeException(e)
                    }
                    response = builder.get()
                }
            }
            response
        }
    }

    fun getPublicTimeline(
        local: Boolean?,
        onlyMedia: Boolean?,
        range: Range?
    ): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/timelines/public")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            addParam(builder, "local", local)
            addParam(builder, "only_media", onlyMedia)

            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }

    fun getHashtagTimeline(
        hashtag: String,
        local: Boolean?,
        onlyMedia: Boolean?,
        range: Range?
    ): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/timelines/tag/{hashtag}")
                    .pathValue("hashtag", _InternalUtility.encode(hashtag))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            addParam(builder, "local", local)
            addParam(builder, "only_media", onlyMedia)

            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }

    fun getListTimeline(
        listId: String?,
        range: Range?
    ): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/timelines/list/{listId}")
                    .pathValue("listId", listId)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }

    fun getConversations(
        range: Range?
    ): Response<Array<Conversation>> {
        return proceed(Array<Conversation>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/conversations")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }
}
