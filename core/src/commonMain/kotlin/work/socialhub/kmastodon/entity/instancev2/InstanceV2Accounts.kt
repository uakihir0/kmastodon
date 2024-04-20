package work.socialhub.kmastodon.entity.instancev2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport


@JsExport
@Serializable
class InstanceV2Accounts {

    @SerialName("max_featured_tags")
    var maxFeaturedTags: Int = 0

    @SerialName("max_pinned_statuses")
    var maxPinnedStatuses: Int? = null
}