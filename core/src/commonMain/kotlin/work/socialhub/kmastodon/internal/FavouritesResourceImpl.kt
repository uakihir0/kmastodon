package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.FavouritesResource
import work.socialhub.kmastodon.api.request.favourites.FavouritesFavouritesRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.favourites.FavouritesFavouritesResponse
import work.socialhub.kmastodon.domain.Service
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType

class FavouritesResourceImpl(
    uri: String,
    accessToken: String,
    service: () -> Service,
) : AbstractAuthResourceImpl(uri, accessToken, service),
    FavouritesResource {

    override fun favourites(
        request: FavouritesFavouritesRequest
    ): Response<Array<FavouritesFavouritesResponse>> = exec {
        HttpRequest()
            .url("${uri}/api/v1/favourites")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .paging(request.range, service())
            .get()
    }
}
