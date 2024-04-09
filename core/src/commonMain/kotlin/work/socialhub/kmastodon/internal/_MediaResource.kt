package work.socialhub.kmastodon.internal

import mastodon4j.api.MediaResource
import mastodon4j.entity.Attachment
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _MediaResource(private val uri: String, accessToken: String) : MediaResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)

    fun postMedia(stream: java.io.InputStream?, name: String?, description: String?): Response<Attachment> {
        return proceed(Attachment::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/media")
                    .file("file", stream, name)
            if (description != null && !description.isEmpty()) {
                builder.param("description", description)
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun postMedia(file: java.io.File?, description: String?): Response<Attachment> {
        return proceed(Attachment::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/media")
                    .file("file", file)
            if (description != null && !description.isEmpty()) {
                builder.param("description", description)
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
