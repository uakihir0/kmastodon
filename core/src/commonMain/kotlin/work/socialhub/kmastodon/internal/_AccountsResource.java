package work.socialhub.kmastodon.internal;

import mastodon4j.Range;
import mastodon4j.api.AccountsResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Account;
import mastodon4j.entity.Relationship;
import mastodon4j.entity.Status;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import java.util.function.Supplier;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _AccountsResource implements AccountsResource {

    private static final long DEFAULT_LIMIT = 40;

    private final String uri;
    private final String bearerToken;
    private final Supplier<Service> service;

    _AccountsResource(Supplier<Service> service, String uri, String accessToken) {
        this.service = service;
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> verifyCredentials() {
        return proceed(Account.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/verify_credentials")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> updateCredentials(String displayName, String note, String avatar, String header) {
        return proceed(Account.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/update_credentials")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)

                    .param("display_name", displayName)
                    .param("note", note)
                    .param("avatar", avatar)
                    .param("header", header)
                    .patch();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account> getAccount(String id) {
        return proceed(Account.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}")
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
    public Response<Account[]> getFollowers(String id) {
        return this.getFollowers(id, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowers(String id, Range range) {
        return proceed(Account[].class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/followers")
                    .pathValue("id", String.valueOf(id));

            _PagingUtility.setPagingParams(builder, range, service.get());

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> getFollowing(String id) {
        return this.getFollowing(id, null);
    }

    @Override
    public Response<Account[]> getFollowing(String id, Range range) {
        return proceed(Account[].class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/following")
                    .pathValue("id", String.valueOf(id));

            _PagingUtility.setPagingParams(builder, range, service.get());

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getStatuses(String id) {
        return this.getStatuses(id, false, false, false, false, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Status[]> getStatuses(String id, Range range) {
        return this.getStatuses(id, false, false, false, false, range);
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

        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/accounts/{id}/statuses")
                            .pathValue("id", String.valueOf(id));

            if (onlyMedia) {
                builder.query("only_media", onlyMedia);
            }
            if (onlyPinned) {
                builder.query("pinned", onlyPinned);
            }
            if (excluedeReplies) {
                builder.query("exclude_replies", excluedeReplies);
            }
            if (excludeReblogs) {
                builder.query("exclude_reblogs", excludeReblogs);
            }

            _PagingUtility.setPagingParams(builder, range, service.get());

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> follow(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/follow")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unfollow(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/unfollow")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> block(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/block")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unblock(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/unblock")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> mute(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/mute")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship> unmute(String id) {
        return proceed(Relationship.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/{id}/unmute")
                    .pathValue("id", String.valueOf(id))
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Relationship[]> relationships(String id, String... ids) {
        return proceed(Relationship[].class, () -> {

            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/relationships")
                    .param("id[]", id);

            if (ids != null) {
                for (String i : ids) {
                    builder.param("id[]", i);
                }
            }

            return builder
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    @Override
    public Response<Account[]> search(String query) {
        return this.search(query, DEFAULT_LIMIT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<Account[]> search(String query, long limit) {
        return proceed(Account[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/accounts/search")
                    .param("q", query)
                    .param("limit", limit)
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }
}
