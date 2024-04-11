package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.nodes.NodesNodeInfoResponse
import kotlin.js.JsExport

@JsExport
interface NodesResource {

    /**
     * Getting node information.
     */
    fun nodeInfo(
    ): Response<NodesNodeInfoResponse>
}
