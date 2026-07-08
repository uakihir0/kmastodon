package work.socialhub.kmastodon.internal

import work.socialhub.kmastodon.Pixelfed
import work.socialhub.kmastodon.api.CollectionsResource
import work.socialhub.kmastodon.api.StoriesResource
import work.socialhub.kmastodon.domain.Service

class PixelfedImpl(
    uri: String,
    accessToken: String,
    service: Service?,
) : MastodonImpl(uri, accessToken, service),
    Pixelfed {

    private val stories: StoriesResource =
        StoriesResourceImpl(uri, accessToken) { service() }
    private val collections: CollectionsResource =
        CollectionsResourceImpl(uri, accessToken) { service() }

    override fun stories() = stories
    override fun collections() = collections
}
