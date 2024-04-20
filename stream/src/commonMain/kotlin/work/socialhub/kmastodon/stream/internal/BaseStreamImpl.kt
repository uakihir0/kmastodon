package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.MastodonFactory
import work.socialhub.kmastodon.stream.StreamClient

open class BaseStreamImpl(
    val uri: String,
    val query: Map<String, String>,
) {
    var client: StreamClient? = null

    fun createClient(): StreamClient {
        val queryString = query
            .map { "${it.key}=${it.value}" }
            .joinToString("&")

        val streamUrl = MastodonFactory
            .instance(uri).instances().instanceV1()
            .data.urls.streamingApi +
                "/api/v1/streaming?" +
                queryString

        return StreamClient(streamUrl)
            .also { this.client = it }
    }
}