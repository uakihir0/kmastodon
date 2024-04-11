package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceResponse
import kotlin.js.JsExport

@JsExport
interface InstancesResource {

    /**
     * Getting instance information.
     */
    fun instance(
    ): Response<InstancesInstanceResponse>
}
