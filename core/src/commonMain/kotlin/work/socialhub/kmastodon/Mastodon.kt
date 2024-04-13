package work.socialhub.kmastodon


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
import kotlin.js.JsExport

@JsExport
interface Mastodon {

    /** Get kind of service  */
    fun service(): Service

    fun apps(): AppsResource
    fun oauth(): OAuthResource
    fun nodes(): NodesResource
    fun emojis(): EmojisResource
    fun instances(): InstancesResource

    fun search(): SearchResource
    fun medias(): MediasResource
    fun trends(): TrendsResource
    fun lists(): ListsResource
    fun polls(): PollsResource
    fun mutes(): MutesResource
    fun blocks(): BlocksResource
    fun reports(): ReportsResource
    fun follows(): FollowsResource
    fun followRequests(): FollowRequestsResource

    fun accounts(): AccountsResource
    fun statuses(): StatusesResource
    fun timelines(): TimelinesResource
    fun favourites(): FavouritesResource
    fun notifications(): NotificationsResource

    fun uri(): String
    fun accessToken(): String
}
