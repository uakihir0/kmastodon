package work.socialhub.kmastodon.api.response

import work.socialhub.kmastodon.entity.share.Link
import work.socialhub.kmastodon.entity.share.RateLimit

class Response<T>(
    var data: T
) {
    var limit: RateLimit? = null
    var link: Link? = null
}
