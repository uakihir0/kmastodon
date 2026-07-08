package work.socialhub.kmastodon.entity.services.gotosocial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * GoToSocial interaction policy on Status.
 * https://docs.gotosocial.org/en/latest/api/swagger/
 */
@JsExport
@Serializable
class InteractionPolicy {

    @SerialName("can_favourite")
    var canFavourite: InteractionPolicyRule? = null

    @SerialName("can_reply")
    var canReply: InteractionPolicyRule? = null

    @SerialName("can_reblog")
    var canReblog: InteractionPolicyRule? = null
}
