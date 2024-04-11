package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.favourites.FavouritesFavouritesRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.favourites.FavouritesFavouritesResponse
import kotlin.js.JsExport

@JsExport
interface FavouritesResource {

    /**
     * Fetching a user's favourites.
     */
    fun favourites(
        request: FavouritesFavouritesRequest
    ): Response<Array<FavouritesFavouritesResponse>>
}
