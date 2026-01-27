package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.NotificationsResource
import work.socialhub.kmastodon.api.request.notifications.NotificationsEditSubscriptionRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsNotificationsRequest
import work.socialhub.kmastodon.api.request.notifications.NotificationsPostSubscriptionRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.notifications.NotificationsEditSubscriptionResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsNotificationResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsNotificationsResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsPostSubscriptionResponse
import work.socialhub.kmastodon.api.response.notifications.NotificationsSubscriptionResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class NotificationsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    NotificationsResource {


    override suspend fun notifications(
        request: NotificationsNotificationsRequest
    ): Response<Array<NotificationsNotificationsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/notifications")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .qwn("account_id", request.id)
                .qwns("types", request.types)
                .qwns("exclude_types", request.excludeTypes)
                .paging(request.range, service())
                .get()
        }
    }

    override fun notificationsBlocking(
        request: NotificationsNotificationsRequest
    ): Response<Array<NotificationsNotificationsResponse>> {
        return toBlocking {
            notifications(request)
        }
    }

    override suspend fun notification(
        request: NotificationsNotificationRequest
    ): Response<NotificationsNotificationResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/notifications/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun notificationBlocking(
        request: NotificationsNotificationRequest
    ): Response<NotificationsNotificationResponse> {
        return toBlocking {
            notification(request)
        }
    }

    override suspend fun clearNotifications(
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1/notifications/clear")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun clearNotificationsBlocking(
    ): ResponseUnit {
        return toBlocking {
            clearNotifications()
        }
    }

    override suspend fun subscription(
    ): Response<NotificationsSubscriptionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/push/subscription")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun subscriptionBlocking(
    ): Response<NotificationsSubscriptionResponse> {
        return toBlocking {
            subscription()
        }
    }

    override suspend fun pushSubscription(
        request: NotificationsPostSubscriptionRequest
    ): Response<NotificationsPostSubscriptionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/push/subscription")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .pwn("subscription[endpoint]", request.endpoint)
                .pwn("subscription[keys][p256dh]", request.p256dh)
                .pwn("subscription[keys][auth]", request.auth)

                .pwn("data[alerts][follow]", request.alert?.follow)
                .pwn("data[alerts][favourite]", request.alert?.favourite)
                .pwn("data[alerts][reblog]", request.alert?.reblog)
                .pwn("data[alerts][mention]", request.alert?.mention)
                .pwn("data[alerts][poll]", request.alert?.poll)
                .pwn("data[alerts][status]", request.alert?.status)
                .post()
        }
    }

    override fun pushSubscriptionBlocking(
        request: NotificationsPostSubscriptionRequest
    ): Response<NotificationsPostSubscriptionResponse> {
        return toBlocking {
            pushSubscription(request)
        }
    }

    override suspend fun editSubscription(
        request: NotificationsEditSubscriptionRequest
    ): Response<NotificationsEditSubscriptionResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/push/subscription")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)

                .pwn("data[alerts][follow]", request.alert?.follow)
                .pwn("data[alerts][favourite]", request.alert?.favourite)
                .pwn("data[alerts][reblog]", request.alert?.reblog)
                .pwn("data[alerts][mention]", request.alert?.mention)
                .pwn("data[alerts][poll]", request.alert?.poll)
                .pwn("data[alerts][status]", request.alert?.status)
                .put()
        }
    }

    override fun editSubscriptionBlocking(
        request: NotificationsEditSubscriptionRequest
    ): Response<NotificationsEditSubscriptionResponse> {
        return toBlocking {
            editSubscription(request)
        }
    }
}
