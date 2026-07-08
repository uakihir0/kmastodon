package work.socialhub.kmastodon.api

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
import kotlin.js.JsExport

/**
 * Pleroma chats.
 * https://docs.pleroma.social/backend/development/API/chats/
 */
@JsExport
interface ChatsResource {

    /**
     * Getting a list of chats.
     */
    suspend fun chats(
        request: ChatsChatsRequest
    ): Response<Array<ChatsChatResponse>>

    @JsExport.Ignore
    fun chatsBlocking(
        request: ChatsChatsRequest
    ): Response<Array<ChatsChatResponse>>

    /**
     * Getting a single chat.
     */
    suspend fun chat(
        request: ChatsChatRequest
    ): Response<ChatsChatResponse>

    @JsExport.Ignore
    fun chatBlocking(
        request: ChatsChatRequest
    ): Response<ChatsChatResponse>

    /**
     * Creating or getting a chat by account id.
     */
    suspend fun chatByAccount(
        request: ChatsByAccountRequest
    ): Response<ChatsChatResponse>

    @JsExport.Ignore
    fun chatByAccountBlocking(
        request: ChatsByAccountRequest
    ): Response<ChatsChatResponse>

    /**
     * Getting messages of a chat.
     */
    suspend fun messages(
        request: ChatsMessagesRequest
    ): Response<Array<ChatsMessageResponse>>

    @JsExport.Ignore
    fun messagesBlocking(
        request: ChatsMessagesRequest
    ): Response<Array<ChatsMessageResponse>>

    /**
     * Posting a message to a chat.
     */
    suspend fun postMessage(
        request: ChatsPostMessageRequest
    ): Response<ChatsMessageResponse>

    @JsExport.Ignore
    fun postMessageBlocking(
        request: ChatsPostMessageRequest
    ): Response<ChatsMessageResponse>

    /**
     * Marking a chat as read up to the given message.
     */
    suspend fun markRead(
        request: ChatsMarkReadRequest
    ): Response<ChatsChatResponse>

    @JsExport.Ignore
    fun markReadBlocking(
        request: ChatsMarkReadRequest
    ): Response<ChatsChatResponse>

    /**
     * Deleting a message from a chat.
     */
    suspend fun deleteMessage(
        request: ChatsDeleteMessageRequest
    ): Response<ChatsMessageResponse>

    @JsExport.Ignore
    fun deleteMessageBlocking(
        request: ChatsDeleteMessageRequest
    ): Response<ChatsMessageResponse>
}
