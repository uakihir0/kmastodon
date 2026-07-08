package work.socialhub.kmastodon.entity.services.pixelfed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Pixelfed story.
 *
 * Pixelfed does not publish a JSON schema for stories, so these fields are
 * best-effort and may need adjustment against a live instance. Unknown keys
 * are ignored and missing keys fall back to defaults, so decoding is safe.
 */
@JsExport
@Serializable
class Story {

    @SerialName("id")
    var id: String? = null

    @SerialName("type")
    var type: String? = null

    @SerialName("url")
    var url: String? = null

    @SerialName("src")
    var src: String? = null

    @SerialName("duration")
    var duration: Int? = null

    @SerialName("seen")
    var seen: Boolean? = null

    @SerialName("created_at")
    var createdAt: String? = null

    @SerialName("expires_at")
    var expiresAt: String? = null
}
