package work.socialhub.kmastodon.internal;

import mastodon4j.Mastodon;
import mastodon4j.Page;
import mastodon4j.Range;
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
import mastodon4j.entity.AccessToken;
import mastodon4j.entity.Account;
import mastodon4j.entity.Alert;
import mastodon4j.entity.Application;
import mastodon4j.entity.Attachment;
import mastodon4j.entity.Card;
import mastodon4j.entity.ClientCredential;
import mastodon4j.entity.Context;
import mastodon4j.entity.Conversation;
import mastodon4j.entity.Emoji;
import mastodon4j.entity.Instance;
import mastodon4j.entity.Node;
import mastodon4j.entity.Notification;
import mastodon4j.entity.Poll;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Report;
import mastodon4j.entity.Results;
import mastodon4j.entity.Status;
import mastodon4j.entity.Subscription;
import mastodon4j.entity.Tag;
import mastodon4j.entity.Trend;
import mastodon4j.entity.request.StatusUpdate;
import mastodon4j.entity.share.Response;
import mastodon4j.streaming.HashtagStream;
import mastodon4j.streaming.PublicStream;
import mastodon4j.streaming.UserStream;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @author hecateball
 */
public final class _Mastodon implements Mastodon {

    private final AccountsResource accounts;
    private final AppsResource apps;
    private final BlocksResource blocks;
    private final FavouritesResource favourites;
    private final FollowRequestsResource followRequests;
    private final FollowsResource follows;
    private final InstancesResource instances;
    private final MediaResource media;
    private final MutesResource mutes;
    private final NotificationsResource notifications;
    private final OauthResource oauth;
    private final ReportsResource reports;
    private final SearchResource search;
    private final StatusesResource statuses;
    private final StreamingResource streaming;
    private final TimelinesResource timelines;
    private final ListsResource list;
    private final TrendResource trend;
    private final PollResource poll;
    private final NodeResource node;
    private final EmojiResource emoji;

    private Service service;

    public _Mastodon(Service service, String uri, String accessToken) {
        this.service = service;

        // No Authorization Endpoints
        this.apps = new _AppsResource(uri);
        this.instances = new _InstancesResource(uri);
        this.oauth = new _OauthResource(uri);
        this.node = new _NodeResource(uri);
        this.emoji = new _EmojiResource(uri);

        // Need Authorization
        this.blocks = new _BlocksResource(uri, accessToken);
        this.followRequests = new _FollowRequestsResource(uri, accessToken);
        this.follows = new _FollowsResource(uri, accessToken);
        this.media = new _MediaResource(uri, accessToken);
        this.mutes = new _MutesResource(uri, accessToken);
        this.reports = new _ReportsResource(uri, accessToken);
        this.search = new _SearchResource(uri, accessToken);
        this.streaming = new _StreamingResource(uri, accessToken);
        this.list = new _ListsResource(uri, accessToken);
        this.trend = new _TrendResource(uri, accessToken);
        this.poll = new _PollResource(uri, accessToken);

        // Need Authorization and Service
        this.accounts = new _AccountsResource(this::service, uri, accessToken);
        this.notifications = new _NotificationsResource(this::service, uri, accessToken);
        this.favourites = new _FavouritesResource(this::service, uri, accessToken);
        this.statuses = new _StatusesResource(this::service, uri, accessToken);
        this.timelines = new _TimelinesResource(this::service, uri, accessToken);
    }

    /**
     * get service
     * (with request if needed.)
     */
    @Override
    public Service service() {
        if (this.service == null) {
            String serviceName = getNodeInfo().get().getSoftware().getName();
            this.service = Service.from(serviceName);
        }
        return this.service;
    }

    @Override
    public AccountsResource accounts() {
        return this.accounts;
    }

    @Override
    public AppsResource apps() {
        return this.apps;
    }

    @Override
    public BlocksResource blocks() {
        return this.blocks;
    }

    @Override
    public FavouritesResource favourites() {
        return this.favourites;
    }

    @Override
    public FollowRequestsResource followRequests() {
        return this.followRequests;
    }

    @Override
    public FollowsResource follows() {
        return this.follows;
    }

    @Override
    public InstancesResource instances() {
        return this.instances;
    }

    @Override
    public MediaResource media() {
        return this.media;
    }

    @Override
    public MutesResource mutes() {
        return this.mutes;
    }

    @Override
    public NotificationsResource notifications() {
        return this.notifications;
    }

    @Override
    public OauthResource oauth() {
        return this.oauth;
    }

    @Override
    public ReportsResource reports() {
        return this.reports;
    }

    @Override
    public SearchResource search() {
        return this.search;
    }

    @Override
    public StatusesResource statuses() {
        return this.statuses;
    }

    @Override
    public StreamingResource streaming() {
        return this.streaming;
    }

    @Override
    public TimelinesResource timelines() {
        return this.timelines;
    }

    @Override
    public ListsResource list() {
        return this.list;
    }

    @Override
    public TrendResource trend() {
        return this.trend;
    }

    @Override
    public PollResource poll() {
        return this.poll;
    }

    @Override
    public NodeResource node() {
        return this.node;
    }

    @Override
    public EmojiResource emoji() {
        return this.emoji;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> verifyCredentials() {
        return accounts().verifyCredentials();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> updateCredentials(String displayName, String note, String avatar, String header) {
        return this.accounts().updateCredentials(displayName, note, avatar, header);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> getAccount(String id) {
        return this.accounts().getAccount(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowers(String id) {
        return this.accounts().getFollowers(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowers(String id, Range range) {
        return this.accounts().getFollowers(id, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowing(String id) {
        return this.accounts().getFollowing(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowing(String id, Range range) {
        return this.accounts().getFollowing(id, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getStatuses(String id) {
        return this.accounts().getStatuses(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getStatuses(String id, Range range) {
        return this.accounts().getStatuses(id, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getStatuses(
            String id,
            boolean onlyPinned,
            boolean onlyMedia,
            boolean excluedeReplies,
            boolean excludeReblogs,
            Range range) {

        return this.accounts().getStatuses(
                id,
                onlyPinned,
                onlyMedia,
                excluedeReplies,
                excludeReblogs,
                range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> follow(String id) {
        return this.accounts().follow(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unfollow(String id) {
        return this.accounts().unfollow(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> block(String id) {
        return this.accounts().block(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unblock(String id) {
        return this.accounts().unblock(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> mute(String id) {
        return this.accounts().mute(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unmute(String id) {
        return this.accounts().unmute(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship[]> relationships(String id, String... ids) {
        return this.accounts().relationships(id, ids);
    }

    @Override
    public Response<Account[]> search(String query) {
        return this.accounts().search(query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> search(String query, long limit) {
        return this.accounts().search(query, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<ClientCredential> registerApplication(Application app, String redirectUris, String scopes) {
        return this.apps().registerApplication(app, redirectUris, scopes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getBlocks() {
        return this.blocks().getBlocks();
    }

    @Override
    public Response<Account[]> getBlocks(Range range) {
        return this.blocks().getBlocks(range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getFavourites() {
        return this.favourites().getFavourites();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getFavourites(Range range) {
        return this.favourites().getFavourites(range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowRequests() {
        return this.followRequests().getFollowRequests();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Void> authorizeFollowRequest(String id) {
        return this.followRequests().authorizeFollowRequest(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Void> rejectFollowRequest(String id) {
        return this.followRequests().rejectFollowRequest(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> remoteFollow(String uri) {
        return this.follows().remoteFollow(uri);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Instance> getInstance() {
        return this.instances().getInstance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Attachment> postMedia(InputStream stream, String name, String description) {
        return this.media().postMedia(stream, name, description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Attachment> postMedia(File file, String description) {
        return this.media().postMedia(file, description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getMutes() {
        return this.mutes().getMutes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Notification[]> getNotifications(
            Range range, List<String> types, List<String> excludeTypes, Long id) {

        return this.notifications().getNotifications(
                range, types, excludeTypes, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Notification> getNotification(String id) {
        return this.notifications().getNotification(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Void> clearNotifications() {
        return this.notifications().clearNotifications();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Subscription> getSubscription() {
        return this.notifications().getSubscription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Subscription> pushSubscription(String endpoint, String p256dh, String auth, Alert alert) {
        return this.notifications().pushSubscription(endpoint, p256dh, auth, alert);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Subscription> editSubscription(Alert alert) {
        return this.notifications().editSubscription(alert);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> issueAccessToken(String clientId, String clientSecret, String emailAddress, String password,
                                                  String scopes) {
        return this.oauth().issueAccessToken(clientId, clientSecret, emailAddress, password, scopes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> issueAccessToken(String clientId, String clientSecret, String redirectUri, String code) {
        return oauth.issueAccessToken(clientId, clientSecret, redirectUri, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> refreshAccessToken(String clientId, String clientSecret, String refreshToken) {
        return oauth.refreshAccessToken(clientId, clientSecret, refreshToken);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthorizationUrl(String clientId, String redirectUri, String scopes) {
        return oauth.getAuthorizationUrl(clientId, redirectUri, scopes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Report[]> getReports() {
        return this.reports().getReports();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Report> postReport(String accountId, String[] statusIds, String comment) {
        return this.reports().postReport(accountId, statusIds, comment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Results> search(
            String query, boolean resolve, boolean onlyFollowing, Page page) {

        return this.search().search(
                query, resolve, onlyFollowing, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> getStatus(String id) {
        return this.statuses().getStatus(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Context> getContext(String id) {
        return this.statuses().getContext(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Card> getCard(String id) {
        return this.statuses().getCard(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getRebloggedBy(String id, Range range) {
        return this.statuses().getRebloggedBy(id, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFavouritedBy(String id, Range range) {
        return this.statuses().getFavouritedBy(id, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> postStatus(StatusUpdate status) {
        return this.statuses().postStatus(status);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Void> deleteStatus(String id) {
        return this.statuses().deleteStatus(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> reblog(String id) {
        return this.statuses().reblog(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> unreblog(String id) {
        return this.statuses().unreblog(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> favourite(String id) {
        return this.statuses().favourite(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status> unfavourite(String id) {
        return this.statuses().unfavourite(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userStream() {
        return this.streaming().userStream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream() {
        return this.streaming().publicStream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream(boolean local) {
        return this.streaming().publicStream(local);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag) {
        return this.streaming().hashtagStream(tag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag, boolean local) {
        return this.streaming().hashtagStream(tag, local);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getHomeTimeline(
            Range range) {
        return this.timelines().getHomeTimeline(range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getPublicTimeline(
            Boolean local, Boolean onlyMedia, Range range) {
        return this.timelines().getPublicTimeline(local, onlyMedia, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getHashtagTimeline(
            String hashtag, Boolean local, Boolean onlyMedia, Range range) {
        return this.timelines().getHashtagTimeline(hashtag, local, onlyMedia, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getListTimeline(String listId, Range range) {
        return this.timelines().getListTimeline(listId, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Conversation[]> getConversations(Range range) {
        return this.timelines().getConversations(range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<mastodon4j.entity.List[]> getLists() {
        return this.list.getLists();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<mastodon4j.entity.List[]> getLists(String id) {
        return this.list.getLists(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getListAccounts(String id, Long limit) {
        return this.getListAccounts(id, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<mastodon4j.entity.List> getList(String id) {
        return this.getList(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<mastodon4j.entity.List> createList(String title) {
        return this.list.createList(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<mastodon4j.entity.List> updateList(String id, String title) {
        return this.list.updateList(id, title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteList(String id) {
        this.list.deleteList(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAccountsToList(String id, long[] accountIds) {
        this.list.addAccountsToList(id, accountIds);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAccountsToList(String id, long[] accountIds) {
        this.list.deleteAccountsToList(id, accountIds);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Trend[]> getTrends(Long limit) {
        return this.trend().getTrends(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Poll> votePoll(String id, long[] choices) {
        return this.poll().votePoll(id, choices);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Node> getNodeInfo() {
        return this.node().getNodeInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Emoji[]> getCustomEmojis() {
        return this.emoji().getCustomEmojis();
    }
}
