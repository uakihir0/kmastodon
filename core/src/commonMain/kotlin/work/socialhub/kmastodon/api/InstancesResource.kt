package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV1Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV2Response
import kotlin.js.JsExport

@JsExport
interface InstancesResource {

    /**
     * Getting instance information.
     */
    suspend fun instanceV1(
    ): Response<InstancesInstanceV1Response>

    @JsExport.Ignore
    fun instanceV1Blocking(
    ): Response<InstancesInstanceV1Response>

    /**
     * Getting instance information.
     * Since v4.0.0
     */
    suspend fun instanceV2(
    ): Response<InstancesInstanceV2Response>

    @JsExport.Ignore
    fun instanceV2Blocking(
    ): Response<InstancesInstanceV2Response>
}
