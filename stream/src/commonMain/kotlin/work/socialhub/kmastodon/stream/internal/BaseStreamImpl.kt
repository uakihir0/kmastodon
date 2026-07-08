package work.socialhub.kmastodon.stream.internal

import work.socialhub.kmastodon.MastodonFactory
import work.socialhub.kmastodon.stream.StreamClient

open class BaseStreamImpl(
    val uri: String,
    val query: Map<String, String>,
) {
    var client: StreamClient? = null

    suspend fun createClient(): StreamClient {
        val queryString = query
            .map { "${it.key}=${it.value}" }
            .joinToString("&")

        // Prefer the streaming base advertised by the instance, but fall back
        // to the instance uri for forks that omit urls.streaming_api.
        val streamingBase = MastodonFactory
            .instance(uri).instances().instanceV1()
            .data.urls?.streamingApi
            ?.takeIf { it.isNotEmpty() }
            ?: uri

        val streamUrl = streamingBase +
                "/api/v1/streaming?" +
                queryString

        return StreamClient(streamUrl)
            .also { this.client = it }
    }
}