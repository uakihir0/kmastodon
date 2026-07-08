package work.socialhub.kmastodon.api.request.collections

import kotlin.js.JsExport

@JsExport
class CollectionsStatusRequest {
    /** collection id */
    var collectionId: String? = null

    /** status (post) id to add or remove */
    var postId: String? = null
}
