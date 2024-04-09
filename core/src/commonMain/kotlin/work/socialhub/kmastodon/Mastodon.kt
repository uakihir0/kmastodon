package work.socialhub.kmastodon

import mastodon4j.api.EmojiResource
import mastodon4j.api.ListsResource
import mastodon4j.api.NodeResource
import mastodon4j.api.PollResource
import mastodon4j.api.ReportsResource
import mastodon4j.api.SearchResource
import mastodon4j.api.StatusesResource
import mastodon4j.api.StreamingResource
import mastodon4j.api.TimelinesResource
import mastodon4j.api.TrendResource
import work.socialhub.kmastodon.api.AccountsResource
import work.socialhub.kmastodon.api.AppsResource
import work.socialhub.kmastodon.api.BlocksResource
import work.socialhub.kmastodon.api.FavouritesResource
import work.socialhub.kmastodon.api.FollowRequestsResource
import work.socialhub.kmastodon.api.FollowsResource
import work.socialhub.kmastodon.api.InstancesResource
import work.socialhub.kmastodon.api.MutesResource
import work.socialhub.kmastodon.api.MediasResource
import work.socialhub.kmastodon.api.NotificationsResource
import work.socialhub.kmastodon.api.OAuthResource
import work.socialhub.kmastodon.domain.Service

interface Mastodon {

    /** Get kind of service  */
    fun service(): Service

    fun accounts(): AccountsResource
    fun apps(): AppsResource
    fun blocks(): BlocksResource
    fun favourites(): FavouritesResource
    fun followRequests(): FollowRequestsResource
    fun follows(): FollowsResource
    fun instances(): InstancesResource
    fun media(): MediasResource
    fun mutes(): MutesResource
    fun notifications(): NotificationsResource
    fun oauth(): OAuthResource

    fun reports(): ReportsResource?

    fun search(): SearchResource?

    fun statuses(): StatusesResource?

    fun streaming(): StreamingResource?

    fun timelines(): TimelinesResource?

    fun list(): ListsResource?

    fun trend(): TrendResource?

    fun poll(): PollResource?

    fun node(): NodeResource?

    fun emoji(): EmojiResource?
}
