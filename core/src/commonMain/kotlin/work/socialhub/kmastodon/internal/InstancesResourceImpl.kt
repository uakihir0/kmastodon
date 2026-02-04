package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.InstancesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV1Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceV2Response
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class InstancesResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    InstancesResource {

    override suspend fun instanceV1(
    ): Response<InstancesInstanceV1Response> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/instance")
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun instanceV1Blocking(
    ): Response<InstancesInstanceV1Response> {
        return toBlocking {
            instanceV1()
        }
    }

    override suspend fun instanceV2(
    ): Response<InstancesInstanceV2Response> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v2/instance")
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun instanceV2Blocking(
    ): Response<InstancesInstanceV2Response> {
        return toBlocking {
            instanceV2()
        }
    }
}
