package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.FavouritesResource
import mastodon4j.domain.Service
import mastodon4j.entity.Status
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _FavouritesResource(
    service: java.util.function.Supplier<Service?>,
    private val uri: String,
    accessToken: String
) : FavouritesResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)
    private val service: java.util.function.Supplier<Service> = service

    val favourites: Response<Array<Status>>
        get() = this.getFavourites(null)

    fun getFavourites(range: Range?): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/favourites")
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }
}
