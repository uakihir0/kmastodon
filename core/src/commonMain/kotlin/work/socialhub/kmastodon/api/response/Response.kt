package work.socialhub.kmastodon.api.response

import work.socialhub.kmastodon.entity.share.Link
import work.socialhub.kmastodon.entity.share.RateLimit
import kotlin.js.JsExport

@JsExport
class Response<T>(
    var data: T
) {
    var limit: RateLimit? = null
    var link: Link? = null
    var json: String? = null
}
