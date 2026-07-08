package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.ChatsResource
import work.socialhub.kmastodon.api.request.chats.ChatsByAccountRequest
import work.socialhub.kmastodon.api.request.chats.ChatsChatRequest
import work.socialhub.kmastodon.api.request.chats.ChatsChatsRequest
import work.socialhub.kmastodon.api.request.chats.ChatsDeleteMessageRequest
import work.socialhub.kmastodon.api.request.chats.ChatsMarkReadRequest
import work.socialhub.kmastodon.api.request.chats.ChatsMessagesRequest
import work.socialhub.kmastodon.api.request.chats.ChatsPostMessageRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.chats.ChatsChatResponse
import work.socialhub.kmastodon.api.response.chats.ChatsMessageResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class ChatsResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    ChatsResource {

    override suspend fun chats(
        request: ChatsChatsRequest
    ): Response<Array<ChatsChatResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .qwn("with_muted", request.withMuted)
                .paging(request.range, service())
                .get()
        }
    }

    override fun chatsBlocking(
        request: ChatsChatsRequest
    ): Response<Array<ChatsChatResponse>> {
        return toBlocking {
            chats(request)
        }
    }

    override suspend fun chat(
        request: ChatsChatRequest
    ): Response<ChatsChatResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun chatBlocking(
        request: ChatsChatRequest
    ): Response<ChatsChatResponse> {
        return toBlocking {
            chat(request)
        }
    }

    override suspend fun chatByAccount(
        request: ChatsByAccountRequest
    ): Response<ChatsChatResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/by-account-id/${request.accountId}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun chatByAccountBlocking(
        request: ChatsByAccountRequest
    ): Response<ChatsChatResponse> {
        return toBlocking {
            chatByAccount(request)
        }
    }

    override suspend fun messages(
        request: ChatsMessagesRequest
    ): Response<Array<ChatsMessageResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/${request.id}/messages")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .paging(request.range, service())
                .get()
        }
    }

    override fun messagesBlocking(
        request: ChatsMessagesRequest
    ): Response<Array<ChatsMessageResponse>> {
        return toBlocking {
            messages(request)
        }
    }

    override suspend fun postMessage(
        request: ChatsPostMessageRequest
    ): Response<ChatsMessageResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/${request.id}/messages")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("content", request.content)
                .pwn("media_id", request.mediaId)
                .post()
        }
    }

    override fun postMessageBlocking(
        request: ChatsPostMessageRequest
    ): Response<ChatsMessageResponse> {
        return toBlocking {
            postMessage(request)
        }
    }

    override suspend fun markRead(
        request: ChatsMarkReadRequest
    ): Response<ChatsChatResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/${request.id}/read")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("last_read_id", request.lastReadId)
                .post()
        }
    }

    override fun markReadBlocking(
        request: ChatsMarkReadRequest
    ): Response<ChatsChatResponse> {
        return toBlocking {
            markRead(request)
        }
    }

    override suspend fun deleteMessage(
        request: ChatsDeleteMessageRequest
    ): Response<ChatsMessageResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1/pleroma/chats/${request.id}/messages/${request.messageId}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .delete()
        }
    }

    override fun deleteMessageBlocking(
        request: ChatsDeleteMessageRequest
    ): Response<ChatsMessageResponse> {
        return toBlocking {
            deleteMessage(request)
        }
    }
}
