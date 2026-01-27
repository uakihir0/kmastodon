package work.socialhub.kmastodon.internal

import kotlinx.coroutines.delay
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.TimelinesResource
import work.socialhub.kmastodon.api.request.timelines.TimelinesConversationsRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHashTagTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesHomeTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesListTimelineRequest
import work.socialhub.kmastodon.api.request.timelines.TimelinesPublicTimelineRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.timelines.TimelinesConversationsResponse
import work.socialhub.kmastodon.api.response.timelines.TimelinesHashTagTimelineResponse
import work.socialhub.kmastodon.api.response.timelines.TimelinesHomeTimelineResponse
import work.socialhub.kmastodon.api.response.timelines.TimelinesListTimelineResponse
import work.socialhub.kmastodon.api.response.timelines.TimelinesPublicTimelineResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class TimelinesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    TimelinesResource {

    override suspend fun homeTimeline(
        request: TimelinesHomeTimelineRequest
    ): Response<Array<TimelinesHomeTimelineResponse>> {
        return proceed {
            var response = HttpRequest()
                .url("${uri}/api/v1/timelines/home")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()

            // 206 (Home feed is regenerating)
            for (i in 0..9) {
                if (response.status == 206) {
                    delay(5000)
                    response = HttpRequest()
                        .url("${uri}/api/v1/timelines/home")
                        .header(AUTHORIZATION, bearerToken())
                        .accept(MediaType.JSON)
                        .paging(request.range, service())
                        .get()
                }
            }
            response
        }
    }

    override fun homeTimelineBlocking(
        request: TimelinesHomeTimelineRequest
    ): Response<Array<TimelinesHomeTimelineResponse>> {
        return toBlocking {
            homeTimeline(request)
        }
    }

    override suspend fun publicTimeline(
        request: TimelinesPublicTimelineRequest
    ): Response<Array<TimelinesPublicTimelineResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/timelines/public")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("local", request.local)
                .pwn("only_media", request.onlyMedia)
                .paging(request.range, service())
                .get()
        }
    }

    override fun publicTimelineBlocking(
        request: TimelinesPublicTimelineRequest
    ): Response<Array<TimelinesPublicTimelineResponse>> {
        return toBlocking {
            publicTimeline(request)
        }
    }

    override suspend fun hashtagTimeline(
        request: TimelinesHashTagTimelineRequest
    ): Response<Array<TimelinesHashTagTimelineResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/timelines/tag/${request.hashtag}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("local", request.local)
                .pwn("only_media", request.onlyMedia)
                .paging(request.range, service())
                .get()
        }
    }

    override fun hashtagTimelineBlocking(
        request: TimelinesHashTagTimelineRequest
    ): Response<Array<TimelinesHashTagTimelineResponse>> {
        return toBlocking {
            hashtagTimeline(request)
        }
    }

    override suspend fun listTimeline(
        request: TimelinesListTimelineRequest
    ): Response<Array<TimelinesListTimelineResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/timelines/list/${request.listId}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun listTimelineBlocking(
        request: TimelinesListTimelineRequest
    ): Response<Array<TimelinesListTimelineResponse>> {
        return toBlocking {
            listTimeline(request)
        }
    }

    override suspend fun conversations(
        request: TimelinesConversationsRequest
    ): Response<Array<TimelinesConversationsResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/conversations")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun conversationsBlocking(
        request: TimelinesConversationsRequest
    ): Response<Array<TimelinesConversationsResponse>> {
        return toBlocking {
            conversations(request)
        }
    }
}
