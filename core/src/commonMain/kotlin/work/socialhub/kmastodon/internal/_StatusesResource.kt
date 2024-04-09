package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.StatusesResource
import mastodon4j.domain.Service
import mastodon4j.entity.Account
import mastodon4j.entity.Card
import mastodon4j.entity.Context
import mastodon4j.entity.Status
import mastodon4j.entity.request.StatusUpdate
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _StatusesResource(
    service: java.util.function.Supplier<Service?>,
    private val uri: String,
    accessToken: String
) : StatusesResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)
    private val service: java.util.function.Supplier<Service> = service

    fun getStatus(id: String): Response<Status> {
        return proceed(Status::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    fun getContext(id: String): Response<Context> {
        return proceed(Context::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/context")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    fun getCard(id: String): Response<Card> {
        return proceed(Card::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/card")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    fun getRebloggedBy(id: String, range: Range?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/statuses/{id}/reblogged_by")
                    .pathValue("id", id.toString())
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }

    fun getFavouritedBy(id: String, range: Range?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/statuses/{id}/favourited_by")
                    .pathValue("id", id.toString())
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder.get()
        }
    }

    fun postStatus(status: StatusUpdate): Response<Status> {
        return proceed(Status::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses")
            if (status.getContent() != null && !status.getContent().isEmpty()) {
                builder.param("status", status.getContent())
            }

            if (status.getInReplyToId() != null) {
                builder.param("in_reply_to_id", java.lang.String.valueOf(status.getInReplyToId()))
            }

            if (status.getSensitive() != null && status.getSensitive()) {
                builder.param("sensitive", "true")
            }

            if (status.getSpoilerText() != null && !status.getSpoilerText().isEmpty()) {
                builder.param("spoiler_text", status.getSpoilerText())
            }

            if (status.getVisibility() != null && !status.getVisibility().isEmpty()) {
                builder.param("visibility", status.getVisibility())
            }

            if (status.getMediaIds() != null && !status.getMediaIds().isEmpty()) {
                for (i in status.getMediaIds()) {
                    builder.param("media_ids[]", i)
                }
            }

            // Poll
            if (status.getPollOptions() != null && !status.getPollOptions().isEmpty()) {
                for (option in status.getPollOptions()) {
                    builder.param("poll[options][]", option)
                }

                if (status.getPollExpiresIn() != null) {
                    builder.param("poll[expires_in]", status.getPollExpiresIn())
                }

                if (status.getPollMultiple() != null) {
                    builder.param("poll[multiple]", status.getPollMultiple())
                }

                if (status.getPollHideTotals() != null) {
                    builder.param("poll[hide_totals]", status.getPollHideTotals())
                }
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun deleteStatus(id: String): Response<java.lang.Void> {
        return proceed {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .delete()
        }
    }

    fun reblog(id: String): Response<Status> {
        return proceed(Status::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/reblog")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun unreblog(id: String): Response<Status> {
        return proceed(Status::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/unreblog")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun favourite(id: String): Response<Status> {
        return proceed(Status::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/favourite")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun unfavourite(id: String): Response<Status> {
        return proceed(Status::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/statuses/{id}/unfavourite")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
