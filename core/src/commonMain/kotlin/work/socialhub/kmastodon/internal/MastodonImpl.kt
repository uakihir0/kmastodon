package work.socialhub.kmastodon.internal

import work.socialhub.kmastodon.Mastodon
import work.socialhub.kmastodon.api.AccountsResource
import work.socialhub.kmastodon.api.AppsResource
import work.socialhub.kmastodon.api.BlocksResource
import work.socialhub.kmastodon.api.EmojisResource
import work.socialhub.kmastodon.api.FavouritesResource
import work.socialhub.kmastodon.api.FollowRequestsResource
import work.socialhub.kmastodon.api.FollowsResource
import work.socialhub.kmastodon.api.InstancesResource
import work.socialhub.kmastodon.api.ListsResource
import work.socialhub.kmastodon.api.MediasResource
import work.socialhub.kmastodon.api.MutesResource
import work.socialhub.kmastodon.api.NodesResource
import work.socialhub.kmastodon.api.NotificationsResource
import work.socialhub.kmastodon.api.OAuthResource
import work.socialhub.kmastodon.api.PollsResource
import work.socialhub.kmastodon.api.ReportsResource
import work.socialhub.kmastodon.api.SearchResource
import work.socialhub.kmastodon.api.StatusesResource
import work.socialhub.kmastodon.api.TimelinesResource
import work.socialhub.kmastodon.api.TrendsResource
import work.socialhub.kmastodon.domain.Service

class MastodonImpl(
    private val uri: String,
    private val accessToken: String,
    private val service: Service?,
) : Mastodon {

    private val apps: AppsResource = AppsResourceImpl(uri)
    private val oauth: OAuthResource = OAuthResourceImpl(uri)
    private val nodes: NodesResource = NodesResourceImpl(uri)
    private val emojis: EmojisResource = EmojisResourceImpl(uri)
    private val instances: InstancesResource = InstancesResourceImpl(uri)

    private val search: SearchResource = SearchResourceImpl(uri, accessToken)
    private val medias: MediasResource = MediasResourceImpl(uri, accessToken)
    private val trends: TrendsResource = TrendsResourceImpl(uri, accessToken)
    private val lists: ListsResource = ListsResourceImpl(uri, accessToken)
    private val polls: PollsResource = PollsResourceImpl(uri, accessToken)
    private val mutes: MutesResource = MutesResourceImpl(uri, accessToken)
    private val blocks: BlocksResource = BlocksResourceImpl(uri, accessToken)
    private val reports: ReportsResource = ReportsResourceImpl(uri, accessToken)
    private val follows: FollowsResource = FollowsResourceImpl(uri, accessToken)
    private val followRequests: FollowRequestsResource = FollowRequestsResourceImpl(uri, accessToken)

    private val accounts: AccountsResource = AccountsResourceImpl(uri, accessToken) { service() }
    private val statuses: StatusesResource = StatusesResourceImpl(uri, accessToken) { service() }
    private val timelines: TimelinesResource = TimelinesResourceImpl(uri, accessToken) { service() }
    private val favourites: FavouritesResource = FavouritesResourceImpl(uri, accessToken) { service() }
    private val notifications: NotificationsResource = NotificationsResourceImpl(uri, accessToken) { service() }

    // private val streaming: StreamingResource = StreamingResourceImpl(uri, accessToken) { service() }

    private var serviceCache: Service? = service

    /**
     * get uri
     */
    override fun uri() = uri

    /**
     * get access token
     */
    override fun accessToken() = accessToken

    /**
     * get service
     * (with request if needed.)
     */

    override fun service(): Service {
        return serviceCache ?: run {
            val serviceName = nodes.nodeInfo().data.software?.name
                ?: throw IllegalStateException("cannot get service name.")
            Service.from(serviceName).also { serviceCache = it }
        }
    }

    override fun apps() = apps
    override fun oauth() = oauth
    override fun nodes() = nodes
    override fun emojis() = emojis
    override fun instances() = instances

    override fun search() = search
    override fun medias() = medias
    override fun trends() = trends

    override fun lists() = lists
    override fun polls() = polls
    override fun mutes() = mutes
    override fun blocks() = blocks
    override fun reports() = reports
    override fun follows() = follows
    override fun followRequests() = followRequests

    override fun accounts() = accounts
    override fun statuses() = statuses
    override fun timelines() = timelines
    override fun favourites() = favourites
    override fun notifications() = notifications

    // override fun streaming() = streaming
}
