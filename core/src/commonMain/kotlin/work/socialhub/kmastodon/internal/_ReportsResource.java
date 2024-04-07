package work.socialhub.kmastodon.internal;

import mastodon4j.api.ReportsResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.Report;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpRequestBuilder;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _ReportsResource implements ReportsResource {

    private final String uri;
    private final String bearerToken;

    _ReportsResource(String uri, String accessToken) {
        this.uri = uri;
        this.bearerToken = _InternalUtility.getBearerToken(accessToken);
    }

    @Override
    public Response<Report[]> getReports() {
        return proceed(Report[].class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/reports")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .get();
        });
    }

    @Override
    public Response<Report> postReport(String accountId, String[] statusIds, String comment) {

        return proceed(Report.class, () -> {

            HttpRequestBuilder builder =
                    new HttpRequestBuilder()
                            .target(this.uri)
                            .path("/api/v1/reports")
                            .param("comment", comment)
                            .param("account_id", String.valueOf(accountId));

            for (String i : statusIds) {
                builder.param("status_ids[]", i);
            }

            return builder.request(HttpMediaType.APPLICATION_JSON)
                    .header("Authorization", this.bearerToken)
                    .post();
        });
    }
}
