package work.socialhub.kmastodon.internal

import mastodon4j.api.ReportsResource
import mastodon4j.entity.Report
import mastodon4j.entity.share.Response
import mastodon4j.internal._InternalUtility.proceed
import net.socialhub.http.HttpMediaType
import net.socialhub.http.HttpRequestBuilder

/**
 * @author hecateball
 */
internal class _ReportsResource(private val uri: String, accessToken: String) : ReportsResource {
    private val bearerToken: String = _InternalUtility.getBearerToken(accessToken)

    val reports: Response<Array<Report>>
        get() = proceed(Array<Report>::class.java) {
            HttpRequestBuilder()
                .target(this.uri)
                .path("/api/v1/reports")
                .request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .get()
        }

    fun postReport(accountId: String, statusIds: Array<String?>, comment: String?): Response<Report> {
        return proceed(Report::class.java) {
            val builder: HttpRequestBuilder =
                HttpRequestBuilder()
                    .target(this.uri)
                    .path("/api/v1/reports")
                    .param("comment", comment)
                    .param("account_id", accountId.toString())
            for (i in statusIds) {
                builder.param("status_ids[]", i)
            }
            builder.request(HttpMediaType.APPLICATION_JSON)
                .header("Authorization", this.bearerToken)
                .post()
        }
    }
}
