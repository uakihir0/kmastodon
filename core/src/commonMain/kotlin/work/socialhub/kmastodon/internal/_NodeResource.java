package work.socialhub.kmastodon.internal;

import mastodon4j.MastodonException;
import mastodon4j.api.NodeResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Node;
import mastodon4j.entity.NodeInfo;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import java.util.List;

import static mastodon4j.internal._InternalUtility.proceed;

public class _NodeResource implements NodeResource {

    private final String uri;

    _NodeResource(String uri) {
        this.uri = uri;
    }

    @Override
    public Response<Node> getNodeInfo() {

        Response<NodeInfo> nodeInfo =
                proceed(NodeInfo.class, () -> {
                    return new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/.well-known/nodeinfo")
                            .request(HttpMediaType.APPLICATION_JSON)
                            .get();
                });

        List<NodeInfo.Links> links = nodeInfo.get().getLinks();
        if (links.isEmpty()) {
            throw new MastodonException(
                    new IllegalStateException(
                            "no node info links."));
        }

        return proceed(Node.class, () -> {
            return new HttpRequestBuilder()
                    .target(links.get(0).getHref())
                    .request(HttpMediaType.APPLICATION_JSON)
                    .get();
        });
    }
}
