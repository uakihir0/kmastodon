package work.socialhub.kmastodon.internal

import work.socialhub.kmastodon.Pleroma
import work.socialhub.kmastodon.api.ChatsResource
import work.socialhub.kmastodon.api.EmojiReactionsResource
import work.socialhub.kmastodon.api.PleromaExtrasResource
import work.socialhub.kmastodon.domain.Service

class PleromaImpl(
    uri: String,
    accessToken: String,
    service: Service?,
) : MastodonImpl(uri, accessToken, service),
    Pleroma {

    private val emojiReactions: EmojiReactionsResource =
        EmojiReactionsResourceImpl(uri, accessToken) { service() }
    private val chats: ChatsResource =
        ChatsResourceImpl(uri, accessToken) { service() }
    private val pleromaExtras: PleromaExtrasResource =
        PleromaExtrasResourceImpl(uri, accessToken) { service() }

    override fun emojiReactions() = emojiReactions
    override fun chats() = chats
    override fun pleromaExtras() = pleromaExtras
}
