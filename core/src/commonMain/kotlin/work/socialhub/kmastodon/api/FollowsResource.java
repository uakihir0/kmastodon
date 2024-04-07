package work.socialhub.kmastodon.api;

import mastodon4j.entity.Account;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface FollowsResource {

    /**
     * Following a remote user.
     *
     * @param uri username@domain of the person you want to follow
     * @return the local representation of the followed account, as an Account
     */
    public Response<Account> remoteFollow(String uri);
}
