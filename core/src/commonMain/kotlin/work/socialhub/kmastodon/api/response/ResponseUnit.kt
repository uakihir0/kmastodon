package work.socialhub.kmastodon.api.response

import work.socialhub.kmastodon.entity.share.Link
import work.socialhub.kmastodon.entity.share.RateLimit

class ResponseUnit {
    var limit: RateLimit? = null
    var link: Link? = null
}