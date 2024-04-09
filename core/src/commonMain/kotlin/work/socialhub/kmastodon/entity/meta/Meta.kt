package work.socialhub.kmastodon.entity.meta

import kotlinx.serialization.Serializable
import kotlin.js.JsExport


@JsExport
@Serializable
class Meta {

    var focus: MetaFocus? = null
    var original: MetaOriginal? = null
}
