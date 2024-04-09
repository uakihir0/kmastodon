package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.InstancesResource
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.instances.InstancesInstanceResponse
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmpcommon.runBlocking

class InstancesResourceImpl(
    uri: String
) : AbstractResourceImpl(uri),
    InstancesResource {

    override fun instance(): Response<InstancesInstanceResponse> {
        return runBlocking {
            proceed {
                HttpRequest()
                    .url("${uri}/api/v1/instance")
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }
}
