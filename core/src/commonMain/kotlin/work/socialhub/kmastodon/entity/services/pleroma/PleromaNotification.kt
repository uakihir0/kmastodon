package work.socialhub.kmastodon.entity.services.pleroma

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Pleroma / Akkoma extension on Notification.
 */
@JsExport
@Serializable
class PleromaNotification {

    @SerialName("is_seen")
    var isSeen: Boolean? = null
}
