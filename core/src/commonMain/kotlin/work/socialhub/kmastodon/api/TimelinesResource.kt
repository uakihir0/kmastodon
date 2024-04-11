package work.socialhub.kmastodon.api

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
import kotlin.js.JsExport

@JsExport
interface TimelinesResource {

    /**
     * Retrieving a home timeline.
     */
    fun homeTimeline(
        request: TimelinesHomeTimelineRequest
    ): Response<Array<TimelinesHomeTimelineResponse>>

    /**
     * Retrieving a public timeline.
     */
    fun publicTimeline(
        request: TimelinesPublicTimelineRequest
    ): Response<Array<TimelinesPublicTimelineResponse>>

    /**
     * Retrieving a tag timeline.
     */
    fun hashtagTimeline(
        request: TimelinesHashTagTimelineRequest
    ): Response<Array<TimelinesHashTagTimelineResponse>>

    /**
     * Retrieving a list timeline.
     */
    fun listTimeline(
        request: TimelinesListTimelineRequest
    ): Response<Array<TimelinesListTimelineResponse>>

    /**
     * Retrieving a conversations.
     */
    fun conversations(
        request: TimelinesConversationsRequest
    ): Response<Array<TimelinesConversationsResponse>>
}
