package work.socialhub.kmastodon.internal

import mastodon4j.api.ListsResource
import mastodon4j.entity.Account
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author uakihir0
 */
class _ListsResource internal constructor(private val uri: String, accessToken: String) : ListsResource {
    private val bearerToken: String = InternalUtility.getBearerToken(accessToken)

    val lists: Response<Array<List>>
        /**
         * {@inheritDoc}
         */
        get() = proceed(Array<List>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists")
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }

    /**
     * {@inheritDoc}
     */
    fun getLists(id: String): Response<Array<List>> {
        return proceed(Array<List>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/accounts/{id}/lists")
                .pathValue("id", id.toString())
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getListAccounts(id: String?, limit: Long?): Response<Array<Account>> {
        return proceed(Array<Account>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists/{id}/accounts")
                .pathValue("id", id)
                .param("limit", stringValue(limit, "40"))
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun getList(id: String?): Response<List> {
        return proceed(List::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists/{id}")
                .pathValue("id", id)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun createList(title: String?): Response<List> {
        return proceed(List::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists")
                .param("title", title)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun updateList(id: String?, title: String?): Response<List> {
        return proceed(List::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists/{id}")
                .pathValue("id", id)
                .param("title", title)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .put()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun deleteList(id: String?) {
        proceed(List::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/lists/{id}")
                .pathValue("id", id)
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .delete()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun addAccountsToList(id: String?, accountIds: LongArray) {
        proceed(List::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}/accounts")
                    .pathValue("id", id)
            for (i in accountIds) {
                builder.param("accountIds[]", i)
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }

    /**
     * {@inheritDoc}
     */
    fun deleteAccountsToList(id: String?, accountIds: LongArray) {
        proceed(List::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}/accounts")
                    .pathValue("id", id)
            for (i in accountIds) {
                builder.param("accountIds[]", i)
            }
            builder
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .delete()
        }
    }

    private fun stringValue(obj: Any?, def: String): String {
        return if ((obj != null)) obj.toString() else def
    }
}
