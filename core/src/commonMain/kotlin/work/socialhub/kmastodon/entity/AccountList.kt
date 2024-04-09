package work.socialhub.kmastodon.entity

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
class AccountList {

    var id: String? = null
    var title: String? = null
}
