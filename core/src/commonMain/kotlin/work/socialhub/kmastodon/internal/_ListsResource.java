package work.socialhub.kmastodon.internal;

import mastodon4j.api.ListsResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Account;
import mastodon4j.entity.List;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author uakihir0
 */
public class _ListsResource implements ListsResource {

    private final String uri;
    private final String bearerToken;

    _ListsResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<List[]> getLists() {
        return proceed(List[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<List[]> getLists(String id) {
        return proceed(List[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/lists")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getListAccounts(String id, Long limit) {
        return proceed(Account[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}/accounts")
                    .pathValue("id", id)
                    .param("limit", stringValue(limit, "40"))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<List> getList(String id) {
        return proceed(List.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}")
                    .pathValue("id", id)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<List> createList(String title) {
        return proceed(List.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists")
                    .param("title", title)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<List> updateList(String id, String title) {
        return proceed(List.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}")
                    .pathValue("id", id)
                    .param("title", title)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .put();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteList(String id) {
        proceed(List.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/lists/{id}")
                    .pathValue("id", id)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .delete();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAccountsToList(String id, long[] accountIds) {
        proceed(List.class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/lists/{id}/accounts")
                            .pathValue("id", id);

            for (long i : accountIds) {
                builder.param("accountIds[]", i);
            }

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAccountsToList(String id, long[] accountIds) {
        proceed(List.class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/lists/{id}/accounts")
                            .pathValue("id", id);

            for (long i : accountIds) {
                builder.param("accountIds[]", i);
            }

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .delete();
        });
    }

    private String stringValue(Object obj, String def) {
        return (obj != null) ? obj.toString() : def;
    }
}
