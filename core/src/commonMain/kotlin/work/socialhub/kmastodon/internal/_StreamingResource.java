package work.socialhub.kmastodon.internal;

import mastodon4j.api.StreamingResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Tag;
import mastodon4j.streaming.HashtagStream;
import mastodon4j.streaming.PublicStream;
import mastodon4j.streaming.UserStream;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.getBearerToken;

/**
 * @author hecateball
 */
final class _StreamingResource implements StreamingResource {

    private final String uri;
    private static UserStream USER_STREAM;
    private static PublicStream PUBLIC_STREAM;
    private static PublicStream LOCAL_PUBLIC_STREAM;

    _StreamingResource(String uri, String accessToken) {
        this.uri = uri;

        // User Stream
        if (_StreamingResource.USER_STREAM == null) {
            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(uri).path("/api/v1/streaming/user");

            if (accessToken != null) {
                String bearerToken = getBearerToken(accessToken);
                builder.header("Authorization", bearerToken);
            }
            _StreamingResource.USER_STREAM = new _UserStream(builder);
        }

        // Public Stream
        if (_StreamingResource.PUBLIC_STREAM == null) {
            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(uri).path("/api/v1/streaming/public");
            _StreamingResource.PUBLIC_STREAM = new _PublicStream(builder);
        }

        // Local Public Stream
        if (_StreamingResource.LOCAL_PUBLIC_STREAM == null) {
            HttpRequestBuilder builder = new HttpRequestBuilder()
                    .target(uri).path("/api/v1/streaming/public/local");
            _StreamingResource.LOCAL_PUBLIC_STREAM = new _PublicStream(builder);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStream userStream() {
        return _StreamingResource.USER_STREAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream() {
        return _StreamingResource.PUBLIC_STREAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicStream publicStream(boolean local) {
        return local ? _StreamingResource.LOCAL_PUBLIC_STREAM : _StreamingResource.PUBLIC_STREAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag) {
        return this.hashtagStream(tag, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagStream hashtagStream(Tag tag, boolean local) {
        HttpRequestBuilder builder = new HttpRequestBuilder()
                .target(this.uri).path("/api/v1/streaming/hashtag");

        if (local) {
            builder.path("/api/v1/streaming/hashtag/local");
        }

        builder.query("tag", tag.getName());
        return new _HashtagStream(builder);
    }

}
