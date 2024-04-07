package work.socialhub.kmastodon.internal;

import mastodon4j.Range;
import mastodon4j.api.TimelinesResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Conversation;
import mastodon4j.entity.Status;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;

import java.util.function.Supplier;

import static mastodon4j.internal._InternalUtility.addParam;
import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _TimelinesResource implements TimelinesResource {

    private final String uri;
    private final String bearerToken;
    private final Supplier<Service> service;

    _TimelinesResource(Supplier<Service> service, String uri, String accessToken) {
        this.service = service;
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Status[]> getHomeTimeline(
            Range range) {

        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/timelines/home")
                            .request(HttpMediaType.APPLICATION_JSON)
                            .header("Authorization", this.bearerToken);

            _PagingUtility.setPagingParams(builder, range, service.get());
            HttpResponse response = builder.get();

            // 206 (Home feed is regenerating)
            for (int i = 0; i < 10; i++) {
                if (response.getStatusCode() == 206) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    response = builder.get();
                }
            }

            return response;
        });
    }

    @Override
    public Response<Status[]> getPublicTimeline(
            Boolean local,
            Boolean onlyMedia,
            Range range) {

        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/timelines/public")
                            .request(HttpMediaType.APPLICATION_JSON)
                            .header("Authorization", this.bearerToken);


            addParam(builder, "local", local);
            addParam(builder, "only_media", onlyMedia);

            _PagingUtility.setPagingParams(builder, range, service.get());
            return builder.get();
        });
    }

    @Override
    public Response<Status[]> getHashtagTimeline(
            String hashtag,
            Boolean local,
            Boolean onlyMedia,
            Range range) {

        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/timelines/tag/{hashtag}")
                            .pathValue("hashtag", _InternalUtility.encode(hashtag))
                            .request(HttpMediaType.APPLICATION_JSON)
                            .header("Authorization", this.bearerToken);

            addParam(builder, "local", local);
            addParam(builder, "only_media", onlyMedia);

            _PagingUtility.setPagingParams(builder, range, service.get());
            return builder.get();
        });
    }

    @Override
    public Response<Status[]> getListTimeline(
            String listId,
            Range range) {

        return proceed(Status[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/timelines/list/{listId}")
                            .pathValue("listId", listId)
                            .request(HttpMediaType.APPLICATION_JSON)
                            .header("Authorization", this.bearerToken);

            _PagingUtility.setPagingParams(builder, range, service.get());
            return builder.get();
        });
    }

    @Override
    public Response<Conversation[]> getConversations(
            Range range) {

        return proceed(Conversation[].class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/conversations")
                            .request(HttpMediaType.APPLICATION_JSON)
                            .header("Authorization", this.bearerToken);

            _PagingUtility.setPagingParams(builder, range, service.get());
            return builder.get();
        });
    }
}
