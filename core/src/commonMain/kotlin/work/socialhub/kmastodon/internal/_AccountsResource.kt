package work.socialhub.kmastodon.internal

import mastodon4j.Range
import mastodon4j.api.AccountsResource
import mastodon4j.domain.Service
import mastodon4j.entity.Account
import mastodon4j.entity.Relationship
import mastodon4j.entity.Status
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _AccountsResource(
    service: java.util.function.Supplier<Service?>,
    private val uri: String,
    accessToken: String
) : AccountsResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)
    private val service: java.util.function.Supplier<Service> = service

    /**
     * {@inheritDoc}
     */
    fun verifyCredentials(): Response<Account> {
        return proceed(Account::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/verify_credentials")
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun updateCredentials(displayName: String?, note: String?, avatar: String?, header: String?): Response<Account> {
        return proceed(Account::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/update_credentials")
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)

                .param("display_name", displayName)
                .param("note", note)
                .param("avatar", avatar)
                .param("header", header)
                .patch()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getAccount(id: String): Response<Account> {
        return proceed(Account::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowers(id: String): Response<Array<Account>> {
        return this.getFollowers(id, null)
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowers(id: String, range: Range?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/followers")
                .pathValue("id", id.toString())
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getFollowing(id: String): Response<Array<Account>> {
        return this.getFollowing(id, null)
    }

    fun getFollowing(id: String, range: Range?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/following")
                .pathValue("id", id.toString())
            _PagingUtility.setPagingParams(builder, range, service.get())
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(id: String): Response<Array<Status>> {
        return this.getStatuses(id, false, false, false, false, null)
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(id: String, range: Range?): Response<Array<Status>> {
        return this.getStatuses(id, false, false, false, false, range)
    }

    /**
     * {@inheritDoc}
     */
    fun getStatuses(
        id: String,
        onlyPinned: Boolean,
        onlyMedia: Boolean,
        excluedeReplies: Boolean,
        excludeReblogs: Boolean,
        range: Range?
    ): Response<Array<Status>> {
        return proceed(Array<Status>::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/statuses")
                    .pathValue("id", id.toString())
            if (onlyMedia) {
                builder.query("only_media", onlyMedia)
            }
            if (onlyPinned) {
                builder.query("pinned", onlyPinned)
            }
            if (excluedeReplies) {
                builder.query("exclude_replies", excluedeReplies)
            }
            if (excludeReblogs) {
                builder.query("exclude_reblogs", excludeReblogs)
            }

            _PagingUtility.setPagingParams(builder, range, service.get())
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun follow(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/follow")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun unfollow(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/unfollow")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun block(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/block")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun unblock(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/unblock")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun mute(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/mute")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun unmute(id: String): Response<Relationship> {
        return proceed(Relationship::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/unmute")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun relationships(id: String?, vararg ids: String?): Response<Array<Relationship>> {
        return proceed(Array<Relationship>::class.java) {
            val builder: HttpRequestBuilder = HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/relationships")
                .param("id[]", id)
            if (ids != null) {
                for (i in ids) {
                    builder.param("id[]", i)
                }
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    fun search(query: String?): Response<Array<Account>> {
        return this.search(query, DEFAULT_LIMIT)
    }

    /**
     * {@inheritDoc}
     */
    fun search(query: String?, limit: Long): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/search")
                .param("q", query)
                .param("limit", limit)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    companion object {
        private const val DEFAULT_LIMIT: Long = 40
    }
}
