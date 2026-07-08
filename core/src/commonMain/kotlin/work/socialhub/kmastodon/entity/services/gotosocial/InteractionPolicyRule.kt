package work.socialhub.kmastodon.entity.services.gotosocial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * A single interaction rule (favourite / reply / reblog) of a GoToSocial
 * interaction policy. Values are keywords (public, followers, following,
 * mutuals, mentioned, author, me) or ActivityPub actor URIs.
 */
@JsExport
@Serializable
class InteractionPolicyRule {

    @SerialName("automatic_approval")
    var automaticApproval: Array<String> = arrayOf()

    @SerialName("manual_approval")
    var manualApproval: Array<String> = arrayOf()
}
