package work.socialhub.kmastodon.internal

import mastodon4j.api.InstancesResource
import mastodon4j.entity.Instance
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _InstancesResource(private val uri: String) : InstancesResource {
    val instance: Response<Instance>
        get() = proceed(Instance::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/instance")
                .request(HttpMediaType.APPLICATION_JSON)
                .get()
        }
}
