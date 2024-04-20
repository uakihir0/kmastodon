package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.InstancesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV1Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV2Response
import work.socialhub.kmastodon.util.MediaType

class InstancesResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    InstancesResource {

    override fun instanceV1(
    ): Response<InstancesInstanceV1Response> = exec {
        HttpRequest()
            .url("${uri}/api/v1/instance")
            .accept(MediaType.JSON)
            .get()
    }

    override fun instanceV2(
    ): Response<InstancesInstanceV2Response> = exec {
        HttpRequest()
            .url("${uri}/api/v2/instance")
            .accept(MediaType.JSON)
            .get()
    }
}
