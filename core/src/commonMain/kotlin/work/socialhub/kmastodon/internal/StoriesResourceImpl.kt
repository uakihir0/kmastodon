package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.StoriesResource
import work.socialhub.kmastodon.api.request.stories.StoriesAddRequest
import work.socialhub.kmastodon.api.request.stories.StoriesPublishRequest
import work.socialhub.kmastodon.api.request.stories.StoriesSelfExpireRequest
import work.socialhub.kmastodon.api.request.stories.StoriesViewersRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.ResponseUnit
import work.socialhub.kmastodon.api.response.stories.StoriesStoryResponse
import work.socialhub.kmastodon.api.response.stories.StoriesViewerResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType
import work.socialhub.kmastodon.util.toBlocking

class StoriesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    StoriesResource {

    override suspend fun carousel(
    ): Response<Array<StoriesStoryResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/stories/carousel")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .get()
        }
    }

    override fun carouselBlocking(
    ): Response<Array<StoriesStoryResponse>> {
        return toBlocking {
            carousel()
        }
    }

    override suspend fun add(
        request: StoriesAddRequest
    ): Response<StoriesStoryResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/stories/add")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .file("file", request.name!!, request.bytes!!)
                .pwn("duration", request.duration)
                .forceMultipartFormData(true)
                .post()
        }
    }

    override fun addBlocking(
        request: StoriesAddRequest
    ): Response<StoriesStoryResponse> {
        return toBlocking {
            add(request)
        }
    }

    override suspend fun publish(
        request: StoriesPublishRequest
    ): Response<StoriesStoryResponse> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.1/stories/publish")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .pwn("media_id", request.mediaId)
                .pwn("caption", request.caption)
                .post()
        }
    }

    override fun publishBlocking(
        request: StoriesPublishRequest
    ): Response<StoriesStoryResponse> {
        return toBlocking {
            publish(request)
        }
    }

    override suspend fun selfExpire(
        request: StoriesSelfExpireRequest
    ): ResponseUnit {
        return proceedUnit {
            HttpRequest()
                .url("${uri}/api/v1.1/stories/self-expire/${request.id}")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .post()
        }
    }

    override fun selfExpireBlocking(
        request: StoriesSelfExpireRequest
    ): ResponseUnit {
        return toBlocking {
            selfExpire(request)
        }
    }

    override suspend fun viewers(
        request: StoriesViewersRequest
    ): Response<Array<StoriesViewerResponse>> {
        return proceed {
            HttpRequest()
                .url("${uri}/api/v1.2/stories/viewers")
                .header(AUTHORIZATION, bearerToken())
                .accept(MediaType.JSON)
                .qwn("id", request.id)
                .get()
        }
    }

    override fun viewersBlocking(
        request: StoriesViewersRequest
    ): Response<Array<StoriesViewerResponse>> {
        return toBlocking {
            viewers(request)
        }
    }
}
