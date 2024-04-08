package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.NotificationsResource
import mastodon4j.domain.Service
import mastodon4j.entity.Alert
import mastodon4j.entity.Notification
import mastodon4j.entity.Subscription
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _NotificationsResource(
    service: java.util.function.Supplier<Service?>,
    private val uri: String,
    accessToken: String
) : NotificationsResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)
    private val service: java.util.function.Supplier<Service> = service

    fun getNotifications(
        range: Range?,
        types: List<String?>?,
        excludeTypes: List<String?>?,
        id: Long?
    ): Response<Array<Notification>> {
        return proceed(Array<Notification>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/notifications")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
            _PagingUtility.setPagingParams(builder, range, service.get())

            if (types != null) {
                for (type in types) {
                    builder.query("types[]", type)
                }
            }

            if (excludeTypes != null) {
                for (excludeType in excludeTypes) {
                    builder.query("exclude_types[]", excludeType)
                }
            }

            if (id != null) {
                builder.query("account_id", id)
            }
            builder.get()
        }
    }

    fun getNotification(id: String): Response<Notification> {
        return proceed(Notification::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/notifications/{id}")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    fun clearNotifications(): Response<java.lang.Void> {
        return proceed {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/notifications/clear")
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    val subscription: Response<Subscription>
        get() = proceed(Subscription::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/push/subscription")
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }

    fun pushSubscription(
        endpoint: String?,
        p256dh: String?,
        auth: String?,
        alert: Alert?
    ): Response<Subscription> {
        return proceed(Subscription::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/push/subscription")
            builder.param("subscription[endpoint]", endpoint)
            builder.param("subscription[keys][p256dh]", p256dh)
            builder.param("subscription[keys][auth]", auth)

            if (alert != null) {
                if (alert.getFollow() != null) {
                    builder.param("data[alerts][follow]", booleanValue(alert.getFollow()))
                }
                if (alert.getFavourite() != null) {
                    builder.param("data[alerts][favourite]", booleanValue(alert.getFavourite()))
                }
                if (alert.getReblog() != null) {
                    builder.param("data[alerts][reblog]", booleanValue(alert.getReblog()))
                }
                if (alert.getMention() != null) {
                    builder.param("data[alerts][mention]", booleanValue(alert.getMention()))
                }
                if (alert.getPoll() != null) {
                    builder.param("data[alerts][poll]", booleanValue(alert.getPoll()))
                }
                if (alert.getStatus() != null) {
                    builder.param("data[alerts][status]", booleanValue(alert.getStatus()))
                }
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    fun editSubscription(alert: Alert?): Response<Subscription> {
        return proceed(Subscription::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/push/subscription")
            if (alert != null) {
                if (alert.getFollow() != null) {
                    builder.param("data[alerts][follow]", booleanValue(alert.getFollow()))
                }
                if (alert.getFavourite() != null) {
                    builder.param("data[alerts][favourite]", booleanValue(alert.getFavourite()))
                }
                if (alert.getReblog() != null) {
                    builder.param("data[alerts][reblog]", booleanValue(alert.getReblog()))
                }
                if (alert.getMention() != null) {
                    builder.param("data[alerts][mention]", booleanValue(alert.getMention()))
                }
                if (alert.getPoll() != null) {
                    builder.param("data[alerts][poll]", booleanValue(alert.getPoll()))
                }
                if (alert.getStatus() != null) {
                    builder.param("data[alerts][status]", booleanValue(alert.getStatus()))
                }
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .put()
        }
    }

    private fun booleanValue(b: Boolean): String {
        return if (b) "true" else "false"
    }
}
