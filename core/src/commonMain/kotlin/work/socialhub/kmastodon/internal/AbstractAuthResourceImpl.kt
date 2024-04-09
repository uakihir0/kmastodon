package work.socialhub.kmastodon.internal

import work.socialhub.kmastodon.domain.Service

abstract class AbstractAuthResourceImpl(
    uri: String,
    val accessToken: String,
    val service: () -> Service = { Service.MASTODON },
) : AbstractResourceImpl(uri) {

    companion object {
        const val PIXELFED_LIMIT_MAX = 50
    }

    fun bearerToken(): String {
        return "Bearer $accessToken"
    }
}