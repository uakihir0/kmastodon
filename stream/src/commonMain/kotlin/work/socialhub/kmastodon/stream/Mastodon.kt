package work.socialhub.kmastodon.stream

import work.socialhub.kmastodon.Mastodon

object MastodonEx {

    fun Mastodon.stream(): StreamResource {
        return StreamResourceImpl(uri(), accessToken())
    }
}