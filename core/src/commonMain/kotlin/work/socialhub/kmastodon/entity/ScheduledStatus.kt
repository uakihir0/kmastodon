package work.socialhub.kmastodon.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * https://docs.joinmastodon.org/entities/ScheduledStatus/
 */
@JsExport
@Serializable
class ScheduledStatus {

    @SerialName("id")
    lateinit var id: String

    @SerialName("scheduled_at")
    lateinit var scheduledAt: String

    @SerialName("params")
    var params: ScheduledStatusParams? = null

    @SerialName("media_attachments")
    var mediaAttachments: Array<Attachment>? = null
}

@JsExport
@Serializable
class ScheduledStatusParams {

    @SerialName("text")
    var text: String? = null

    @SerialName("poll")
    var poll: Poll? = null

    @SerialName("media_ids")
    var mediaIds: Array<String>? = null

    @SerialName("sensitive")
    var sensitive: Boolean? = null

    @SerialName("spoiler_text")
    var spoilerText: String? = null

    @SerialName("visibility")
    var visibility: String? = null

    @SerialName("in_reply_to_id")
    var inReplyToId: String? = null

    @SerialName("language")
    var language: String? = null

    @SerialName("application_id")
    var applicationId: String? = null

    @SerialName("scheduled_at")
    var scheduledAt: String? = null

    @SerialName("idempotency")
    var idempotency: String? = null

    @SerialName("with_rate_limit")
    var withRateLimit: Boolean? = null
}
