package work.socialhub.kmastodon;

import mastodon4j.api.AccountsResource;
import mastodon4j.api.AppsResource;
import mastodon4j.api.BlocksResource;
import mastodon4j.api.EmojiResource;
import mastodon4j.api.FavouritesResource;
import mastodon4j.api.FollowRequestsResource;
import mastodon4j.api.FollowsResource;
import mastodon4j.api.InstancesResource;
import mastodon4j.api.ListsResource;
import mastodon4j.api.MediaResource;
import mastodon4j.api.MutesResource;
import mastodon4j.api.NodeResource;
import mastodon4j.api.NotificationsResource;
import mastodon4j.api.OauthResource;
import mastodon4j.api.PollResource;
import mastodon4j.api.ReportsResource;
import mastodon4j.api.SearchResource;
import mastodon4j.api.StatusesResource;
import mastodon4j.api.StreamingResource;
import mastodon4j.api.TimelinesResource;
import mastodon4j.api.TrendResource;
import mastodon4j.domain.Service;

/**
 * @author hecateball
 */
public interface Mastodon extends AccountsResource, AppsResource, BlocksResource, FavouritesResource,
        FollowRequestsResource, FollowsResource, InstancesResource, MediaResource, MutesResource, NotificationsResource,
        OauthResource, ReportsResource, SearchResource, StatusesResource, StreamingResource, TimelinesResource, ListsResource,
        TrendResource, PollResource, NodeResource, EmojiResource {

    /** Get kind of service */
    public Service service();

    public AccountsResource accounts();

    public AppsResource apps();

    public BlocksResource blocks();

    public FavouritesResource favourites();

    public FollowRequestsResource followRequests();

    public FollowsResource follows();

    public InstancesResource instances();

    public MediaResource media();

    public MutesResource mutes();

    public NotificationsResource notifications();

    public OauthResource oauth();

    public ReportsResource reports();

    public SearchResource search();

    public StatusesResource statuses();

    public StreamingResource streaming();

    public TimelinesResource timelines();

    public ListsResource list();

    public TrendResource trend();

    public PollResource poll();

    public NodeResource node();

    public EmojiResource emoji();
}
