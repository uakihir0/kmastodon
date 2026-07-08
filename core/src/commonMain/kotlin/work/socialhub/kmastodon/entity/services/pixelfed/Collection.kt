package work.socialhub.kmastodon.entity.services.pixelfed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Pixelfed collection.
 *
 * Pixelfed does not publish a JSON schema for collections, so these fields are
 * best-effort and may need adjustment against a live instance. Unknown keys
 * are ignored and missing keys fall back to defaults, so decoding is safe.
 */
@JsExport
@Serializable
class Collection {

    @SerialName("id")
    var id: String? = null

    @SerialName("title")
    var title: String? = null

    @SerialName("description")
    var description: String? = null

    @SerialName("visibility")
    var visibility: String? = null

    @SerialName("thumbnail")
    var thumbnail: String? = null

    @SerialName("post_count")
    var postCount: Int? = null

    @SerialName("url")
    var url: String? = null
}
