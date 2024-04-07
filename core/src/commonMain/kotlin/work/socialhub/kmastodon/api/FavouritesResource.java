package work.socialhub.kmastodon.api;

import mastodon4j.Range;
import mastodon4j.entity.Status;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface FavouritesResource {

    /**
     * Fetching a user's favourites.
     *
     * @return an array of Statuses favourited by the authenticated user
     */
    public Response<Status[]> getFavourites();

    /**
     * Fetching a user's favourites.
     *
     * @return an array of Statuses favourited by the authenticated user
     */
    public Response<Status[]> getFavourites(Range range);
}
