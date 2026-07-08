package work.socialhub.kmastodon.api.request.pleroma

import kotlin.js.JsExport

@JsExport
class PleromaReadNotificationsRequest {
    /** mark a single notification read (mutually exclusive with maxId) */
    var id: String? = null

    /** mark all notifications up to and including this id read */
    var maxId: String? = null
}
