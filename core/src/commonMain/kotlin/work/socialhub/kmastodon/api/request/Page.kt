package work.socialhub.kmastodon.api.request

import kotlin.js.JsExport

@JsExport
class Page {
    var offset: Int? = null
    var limit: Int? = null
}
