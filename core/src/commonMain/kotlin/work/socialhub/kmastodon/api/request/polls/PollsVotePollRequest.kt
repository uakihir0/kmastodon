package work.socialhub.kmastodon.api.request.polls

import kotlin.js.JsExport

@JsExport
class PollsVotePollRequest {
    var id: String? = null
    var choices: Array<Int>? = null
}