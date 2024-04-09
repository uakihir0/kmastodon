package work.socialhub.kmastodon.internal

import mastodon4j.Page
import mastodon4j.Range
import mastodon4j.api.AccountsResource
import mastodon4j.api.AppsResource
import mastodon4j.api.BlocksResource
import mastodon4j.api.EmojiResource
import mastodon4j.api.FavouritesResource
import mastodon4j.api.FollowRequestsResource
import mastodon4j.api.FollowsResource
import mastodon4j.api.InstancesResource
import mastodon4j.api.ListsResource
import mastodon4j.api.MediaResource
import mastodon4j.api.MutesResource
import mastodon4j.api.NodeResource
import mastodon4j.api.NotificationsResource
import mastodon4j.api.OauthResource
import mastodon4j.api.PollResource
import mastodon4j.api.ReportsResource
import mastodon4j.api.SearchResource
import mastodon4j.api.StatusesResource
import mastodon4j.api.StreamingResource
import mastodon4j.api.TimelinesResource
import mastodon4j.api.TrendResource
import mastodon4j.domain.Service
import mastodon4j.entity.AccessToken
import mastodon4j.entity.Account
import mastodon4j.entity.Alert
import mastodon4j.entity.Application
import mastodon4j.entity.Attachment
import mastodon4j.entity.Card
import mastodon4j.entity.ClientCredential
import mastodon4j.entity.Context
import mastodon4j.entity.Conversation
import mastodon4j.entity.Emoji
import mastodon4j.entity.Instance
import mastodon4j.entity.Node
import mastodon4j.entity.Notification
import mastodon4j.entity.Poll
import mastodon4j.entity.Relationship
import mastodon4j.entity.Report
import mastodon4j.entity.Results
import mastodon4j.entity.Status
import mastodon4j.entity.Subscription
import mastodon4j.entity.Tag
import mastodon4j.entity.Trend
import mastodon4j.entity.request.StatusUpdate
import mastodon4j.entity.share.Response
import mastodon4j.streaming.HashtagStream
import mastodon4j.streaming.PublicStream
import mastodon4j.streaming.UserStream
import work.socialhub.kmastodon.Mastodon
import work.socialhub.kmastodon.internal.stream._StreamingResource

class _Mastodon(
    service: Service?,
    uri: String,
    accessToken: String
) : Mastodon {
    private val accounts: AccountsResource
    private val apps: AppsResource
    private val blocks: BlocksResource
    private val favourites: FavouritesResource
    private val followRequests: FollowRequestsResource
    private val follows: FollowsResource
    private val instances: InstancesResource
    private val media: MediaResource
    private val mutes: MutesResource
    private val notifications: NotificationsResource
    private val oauth: OauthResource
    private val reports: ReportsResource
    private val search: SearchResource
    private val statuses: StatusesResource
    private val streaming: StreamingResource
    private val timelines: TimelinesResource
    private val list: ListsResource
    private val trend: TrendResource
    private val poll: PollResource
    private val node: NodeResource
    private val emoji: EmojiResource

    private var service: Service?

    init {
        this.service = service

        // No Authorization Endpoints
        this.apps = AppsResourceImpl(uri)
        this.instances = InstancesResourceImpl(uri)
        this.oauth = _OauthResource(uri)
        this.node = _NodeResource(uri)
        this.emoji = EmojisResourceImpl(uri)

        // Need Authorization
        this.blocks = BlocksResourceImpl(uri, accessToken)
        this.followRequests = FollowRequestsResourceImpl(uri, accessToken)
        this.follows = FollowsResourceImpl(uri, accessToken)
        this.media = MediasResourceImpl(uri, accessToken)
        this.mutes = _MutesResource(uri, accessToken)
        this.reports = _ReportsResource(uri, accessToken)
        this.search = _SearchResource(uri, accessToken)
        this.streaming = _StreamingResource(uri, accessToken)
        this.list = ListsResourceImpl(uri, accessToken)
        this.trend = _TrendResource(uri, accessToken)
        this.poll = _PollResource(uri, accessToken)

        // Need Authorization and Service
        this.accounts = AccountsResourceImpl({ this.service() }, uri, accessToken)
        this.notifications = _NotificationsResource({ this.service() }, uri, accessToken)
        this.favourites = FavouritesResourceImpl({ this.service() }, uri, accessToken)
        this.statuses = _StatusesResource({ this.service() }, uri, accessToken)
        this.timelines = _TimelinesResource({ this.service() }, uri, accessToken)
    }

    /**
     * get service
     * (with request if needed.)
     */
    fun service(): Service? {
        if (this.service == null) {
            val serviceName: String = nodeInfo.get().getSoftware().getName()
            this.service = Service.from(serviceName)
        }
        return this.service
    }

    fun accounts(): AccountsResource {
        return this.accounts
    }

    fun apps(): AppsResource {
        return this.apps
    }

    fun blocks(): BlocksResource {
        return this.blocks
    }

    fun favourites(): FavouritesResource {
        return this.favourites
    }

    fun followRequests(): FollowRequestsResource {
        return this.followRequests
    }

    fun follows(): FollowsResource {
        return this.follows
    }

    fun instances(): InstancesResource {
        return this.instances
    }

    fun media(): MediaResource {
        return this.media
    }

    fun mutes(): MutesResource {
        return this.mutes
    }

    fun notifications(): NotificationsResource {
        return this.notifications
    }

    fun oauth(): OauthResource {
        return this.oauth
    }

    fun reports(): ReportsResource {
        return this.reports
    }

    fun search(): SearchResource {
        return this.search
    }

    fun statuses(): StatusesResource {
        return this.statuses
    }

    fun streaming(): StreamingResource {
        return this.streaming
    }

    fun timelines(): TimelinesResource {
        return this.timelines
    }

    fun list(): ListsResource {
        return this.list
    }

    fun trend(): TrendResource {
        return this.trend
    }

    fun poll(): PollResource {
        return this.poll
    }

    fun node(): NodeResource {
        return this.node
    }

    fun emoji(): EmojiResource {
        return this.emoji
    }

    /**
     * {@inheritDoc}
     */
    fun verifyCredentials(): Response<Account> {
        return accounts().verifyCredentials()
    }

    /**
     * {@inheritDoc}
     */
    fun updateCredentials(displayName: String?, note: String?, avatar: String?, header: String?): Response<Account> {
        return accounts().updateCredentials(displayName, note, avatar, header)
    }

    /**
     * {@inheritDoc}
     */
    fun getAccount(id: String?): Response<Account> {
        return accounts().getAccount(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowers(id: String?): Response<Array<Account>> {
        return accounts().getFollowers(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowers(id: String?, range: Range?): Response<Array<Account>> {
        return accounts().getFollowers(id, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowing(id: String?): Response<Array<Account>> {
        return accounts().getFollowing(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowing(id: String?, range: Range?): Response<Array<Account>> {
        return accounts().getFollowing(id, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(id: String?): Response<Array<Status>> {
        return accounts().getStatuses(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(id: String?, range: Range?): Response<Array<Status>> {
        return accounts().getStatuses(id, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(
        id: String?,
        onlyPinned: Boolean,
        onlyMedia: Boolean,
        excluedeReplies: Boolean,
        excludeReblogs: Boolean,
        range: Range?
    ): Response<Array<Status>> {
        return accounts().getStatuses(
            id,
            onlyPinned,
            onlyMedia,
            excluedeReplies,
            excludeReblogs,
            range
        )
    }

    /**
     * {@inheritDoc}
     */
    fun follow(id: String?): Response<Relationship> {
        return accounts().follow(id)
    }

    /**
     * {@inheritDoc}
     */
    fun unfollow(id: String?): Response<Relationship> {
        return accounts().unfollow(id)
    }

    /**
     * {@inheritDoc}
     */
    fun block(id: String?): Response<Relationship> {
        return accounts().block(id)
    }

    /**
     * {@inheritDoc}
     */
    fun unblock(id: String?): Response<Relationship> {
        return accounts().unblock(id)
    }

    /**
     * {@inheritDoc}
     */
    fun mute(id: String?): Response<Relationship> {
        return accounts().mute(id)
    }

    /**
     * {@inheritDoc}
     */
    fun unmute(id: String?): Response<Relationship> {
        return accounts().unmute(id)
    }

    /**
     * {@inheritDoc}
     */
    fun relationships(id: String?, vararg ids: String?): Response<Array<Relationship>> {
        return accounts().relationships(id, ids)
    }

    fun search(query: String?): Response<Array<Account>> {
        return accounts().search(query)
    }

    /**
     * {@inheritDoc}
     */
    fun search(query: String?, limit: Long): Response<Array<Account>> {
        return accounts().search(query, limit)
    }

    /**
     * {@inheritDoc}
     */
    fun registerApplication(app: Application?, redirectUris: String?, scopes: String?): Response<ClientCredential> {
        return apps().registerApplication(app, redirectUris, scopes)
    }

    /**
     * {@inheritDoc}
     */
    fun getBlocks(): Response<Array<Account>> {
        return blocks().getBlocks()
    }

    fun getBlocks(range: Range?): Response<Array<Account>> {
        return blocks().getBlocks(range)
    }

    /**
     * {@inheritDoc}
     */
    fun getFavourites(): Response<Array<Status>> {
        return favourites().getFavourites()
    }

    /**
     * {@inheritDoc}
     */
    fun getFavourites(range: Range?): Response<Array<Status>> {
        return favourites().getFavourites(range)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowRequests(): Response<Array<Account>> {
        return followRequests().getFollowRequests()
    }

    /**
     * {@inheritDoc}
     */
    fun authorizeFollowRequest(id: String?): Response<java.lang.Void> {
        return followRequests().authorizeFollowRequest(id)
    }

    /**
     * {@inheritDoc}
     */
    fun rejectFollowRequest(id: String?): Response<java.lang.Void> {
        return followRequests().rejectFollowRequest(id)
    }

    /**
     * {@inheritDoc}
     */
    fun remoteFollow(uri: String?): Response<Account> {
        return follows().remoteFollow(uri)
    }

    val instance: Response<Instance>
        /**
         * {@inheritDoc}
         */
        get() = instances().getInstance()

    /**
     * {@inheritDoc}
     */
    fun postMedia(stream: java.io.InputStream?, name: String?, description: String?): Response<Attachment> {
        return media().postMedia(stream, name, description)
    }

    /**
     * {@inheritDoc}
     */
    fun postMedia(file: java.io.File?, description: String?): Response<Attachment> {
        return media().postMedia(file, description)
    }

    /**
     * {@inheritDoc}
     */
    fun getMutes(): Response<Array<Account>> {
        return mutes().getMutes()
    }

    /**
     * {@inheritDoc}
     */
    fun getNotifications(
        range: Range?, types: List<String?>?, excludeTypes: List<String?>?, id: Long?
    ): Response<Array<Notification>> {
        return notifications().getNotifications(
            range, types, excludeTypes, id
        )
    }

    /**
     * {@inheritDoc}
     */
    fun getNotification(id: String?): Response<Notification> {
        return notifications().getNotification(id)
    }

    /**
     * {@inheritDoc}
     */
    fun clearNotifications(): Response<java.lang.Void> {
        return notifications().clearNotifications()
    }

    val subscription: Response<Subscription>
        /**
         * {@inheritDoc}
         */
        get() = notifications().getSubscription()

    /**
     * {@inheritDoc}
     */
    fun pushSubscription(endpoint: String?, p256dh: String?, auth: String?, alert: Alert?): Response<Subscription> {
        return notifications().pushSubscription(endpoint, p256dh, auth, alert)
    }

    /**
     * {@inheritDoc}
     */
    fun editSubscription(alert: Alert?): Response<Subscription> {
        return notifications().editSubscription(alert)
    }

    /**
     * {@inheritDoc}
     */
    fun issueAccessToken(
        clientId: String?, clientSecret: String?, emailAddress: String?, password: String?,
        scopes: String?
    ): Response<AccessToken> {
        return oauth().issueAccessToken(clientId, clientSecret, emailAddress, password, scopes)
    }

    /**
     * {@inheritDoc}
     */
    fun issueAccessToken(
        clientId: String?,
        clientSecret: String?,
        redirectUri: String?,
        code: String?
    ): Response<AccessToken> {
        return oauth.issueAccessToken(clientId, clientSecret, redirectUri, code)
    }

    /**
     * {@inheritDoc}
     */
    fun refreshAccessToken(clientId: String?, clientSecret: String?, refreshToken: String?): Response<AccessToken> {
        return oauth.refreshAccessToken(clientId, clientSecret, refreshToken)
    }

    /**
     * {@inheritDoc}
     */
    fun getAuthorizationUrl(clientId: String?, redirectUri: String?, scopes: String?): String {
        return oauth.getAuthorizationUrl(clientId, redirectUri, scopes)
    }

    /**
     * {@inheritDoc}
     */
    fun getReports(): Response<Array<Report>> {
        return reports().getReports()
    }

    /**
     * {@inheritDoc}
     */
    fun postReport(accountId: String?, statusIds: Array<String?>?, comment: String?): Response<Report> {
        return reports().postReport(accountId, statusIds, comment)
    }

    /**
     * {@inheritDoc}
     */
    fun search(
        query: String?, resolve: Boolean, onlyFollowing: Boolean, page: Page?
    ): Response<Results> {
        return this.search().search(
            query, resolve, onlyFollowing, page
        )
    }

    /**
     * {@inheritDoc}
     */
    fun getStatus(id: String?): Response<Status> {
        return statuses().getStatus(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getContext(id: String?): Response<Context> {
        return statuses().getContext(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getCard(id: String?): Response<Card> {
        return statuses().getCard(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getRebloggedBy(id: String?, range: Range?): Response<Array<Account>> {
        return statuses().getRebloggedBy(id, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getFavouritedBy(id: String?, range: Range?): Response<Array<Account>> {
        return statuses().getFavouritedBy(id, range)
    }

    /**
     * {@inheritDoc}
     */
    fun postStatus(status: StatusUpdate?): Response<Status> {
        return statuses().postStatus(status)
    }

    /**
     * {@inheritDoc}
     */
    fun deleteStatus(id: String?): Response<java.lang.Void> {
        return statuses().deleteStatus(id)
    }

    /**
     * {@inheritDoc}
     */
    fun reblog(id: String?): Response<Status> {
        return statuses().reblog(id)
    }

    /**
     * {@inheritDoc}
     */
    fun unreblog(id: String?): Response<Status> {
        return statuses().unreblog(id)
    }

    /**
     * {@inheritDoc}
     */
    fun favourite(id: String?): Response<Status> {
        return statuses().favourite(id)
    }

    /**
     * {@inheritDoc}
     */
    fun unfavourite(id: String?): Response<Status> {
        return statuses().unfavourite(id)
    }

    /**
     * {@inheritDoc}
     */
    fun userStream(): UserStream {
        return streaming().userStream()
    }

    /**
     * {@inheritDoc}
     */
    fun publicStream(): PublicStream {
        return streaming().publicStream()
    }

    /**
     * {@inheritDoc}
     */
    fun publicStream(local: Boolean): PublicStream {
        return streaming().publicStream(local)
    }

    /**
     * {@inheritDoc}
     */
    fun hashtagStream(tag: Tag?): HashtagStream {
        return streaming().hashtagStream(tag)
    }

    /**
     * {@inheritDoc}
     */
    fun hashtagStream(tag: Tag?, local: Boolean): HashtagStream {
        return streaming().hashtagStream(tag, local)
    }

    /**
     * {@inheritDoc}
     */
    fun getHomeTimeline(
        range: Range?
    ): Response<Array<Status>> {
        return timelines().getHomeTimeline(range)
    }

    /**
     * {@inheritDoc}
     */
    fun getPublicTimeline(
        local: Boolean?, onlyMedia: Boolean?, range: Range?
    ): Response<Array<Status>> {
        return timelines().getPublicTimeline(local, onlyMedia, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getHashtagTimeline(
        hashtag: String?, local: Boolean?, onlyMedia: Boolean?, range: Range?
    ): Response<Array<Status>> {
        return timelines().getHashtagTimeline(hashtag, local, onlyMedia, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getListTimeline(listId: String?, range: Range?): Response<Array<Status>> {
        return timelines().getListTimeline(listId, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getConversations(range: Range?): Response<Array<Conversation>> {
        return timelines().getConversations(range)
    }

    val lists: Response<Array<mastodon4j.entity.List>>
        /**
         * {@inheritDoc}
         */
        get() = list.getLists()

    /**
     * {@inheritDoc}
     */
    fun getLists(id: String?): Response<Array<mastodon4j.entity.List>> {
        return list.getLists(id)
    }

    /**
     * {@inheritDoc}
     */
    fun getListAccounts(id: String?, limit: Long?): Response<Array<Account>> {
        return this.getListAccounts(id, limit)
    }

    /**
     * {@inheritDoc}
     */
    fun getList(id: String?): Response<mastodon4j.entity.List> {
        return this.getList(id)
    }

    /**
     * {@inheritDoc}
     */
    fun createList(title: String?): Response<mastodon4j.entity.List> {
        return list.createList(title)
    }

    /**
     * {@inheritDoc}
     */
    fun updateList(id: String?, title: String?): Response<mastodon4j.entity.List> {
        return list.updateList(id, title)
    }

    /**
     * {@inheritDoc}
     */
    fun deleteList(id: String?) {
        list.deleteList(id)
    }

    /**
     * {@inheritDoc}
     */
    fun addAccountsToList(id: String?, accountIds: LongArray?) {
        list.addAccountsToList(id, accountIds)
    }

    /**
     * {@inheritDoc}
     */
    fun deleteAccountsToList(id: String?, accountIds: LongArray?) {
        list.deleteAccountsToList(id, accountIds)
    }

    /**
     * {@inheritDoc}
     */
    fun getTrends(limit: Long?): Response<Array<Trend>> {
        return trend().getTrends(limit)
    }

    /**
     * {@inheritDoc}
     */
    fun votePoll(id: String?, choices: LongArray?): Response<Poll> {
        return poll().votePoll(id, choices)
    }

    val nodeInfo: Response<Node>
        /**
         * {@inheritDoc}
         */
        get() = node().getNodeInfo()

    val customEmojis: Response<Array<Emoji>>
        /**
         * {@inheritDoc}
         */
        get() = emoji().getCustomEmojis()
}
