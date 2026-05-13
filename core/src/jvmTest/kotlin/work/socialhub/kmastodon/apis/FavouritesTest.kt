package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.favourites.FavouritesFavouritesRequest
import kotlin.test.Test

class FavouritesTest : AbstractTest() {

    @Test
    fun testFavourites() = runTest {
        val response = mastodon().favourites()
            .favourites(FavouritesFavouritesRequest())
        println("Favourites count: ${response.data.size}")
    }
}
