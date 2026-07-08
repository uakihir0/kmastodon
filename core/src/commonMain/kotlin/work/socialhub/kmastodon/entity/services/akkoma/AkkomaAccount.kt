package work.socialhub.kmastodon.entity.services.akkoma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Akkoma extension on Account.
 * https://docs.akkoma.dev/stable/development/API/differences_in_mastoapi_responses/
 */
@JsExport
@Serializable
class AkkomaAccount {

    // Note: the "instance" object is intentionally not mapped here; its shape
    // varies and unknown keys are ignored by the JSON decoder.

    @SerialName("status_ttl_days")
    var statusTtlDays: Int? = null

    @SerialName("permit_followback")
    var permitFollowback: Boolean? = null
}
