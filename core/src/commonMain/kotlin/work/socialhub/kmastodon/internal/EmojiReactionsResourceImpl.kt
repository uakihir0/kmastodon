package work.socialhub.kmastodon.internal

import io.ktor.http.*
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.EmojiReactionsResource
import work.socialhub.kmastodon.api.request.emojireactions.EmojiReactionsReactRequest
import work.socialhub.kmastodon.api.request.emojireactions.EmojiReactionsReactionsRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.emojireactions.EmojiReactionsReactResponse
import work.socialhub.kmastodon.api.response.emojireactions.EmojiReactionsReactionsResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class EmojiReactionsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    EmojiReactionsResource {

    override suspend fun reactions(
        request: EmojiReactionsReactionsRequest
    ): Response<Array<EmojiReactionsReactionsResponse>> {
        // Optionally scope to a single emoji.
        val path = request.emoji
            ?.let { "${uri}/api/v1/pleroma/statuses/${request.id}/reactions/${it.encodeURLPath()}" }
            ?: "${uri}/api/v1/pleroma/statuses/${request.id}/reactions"

        return proceed {
            HttpRequest()
                .url(path)
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun reactionsBlocking(
        request: EmojiReactionsReactionsRequest
    ): Response<Array<EmojiReactionsReactionsResponse>> {
        return toBlocking {
            reactions(request)
        }
    }

    override suspend fun react(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse> {
        val emoji = request.emoji?.encodeURLPath()
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/statuses/${request.id}/reactions/${emoji}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .put()
        }
    }

    override fun reactBlocking(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse> {
        return toBlocking {
            react(request)
        }
    }

    override suspend fun unreact(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse> {
        val emoji = request.emoji?.encodeURLPath()
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/statuses/${request.id}/reactions/${emoji}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .delete()
        }
    }

    override fun unreactBlocking(
        request: EmojiReactionsReactRequest
    ): Response<EmojiReactionsReactResponse> {
        return toBlocking {
            unreact(request)
        }
    }
}
