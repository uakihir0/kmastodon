package work.socialhub.kmastodon.internal

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.kmastodon.api.ReportsResource
import work.socialhub.kmastodon.api.request.reports.ReportsPostReportRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.reports.ReportsPostReportResponse
import work.socialhub.kmastodon.api.response.reports.ReportsReportsResponse
import work.socialhub.kmastodon.util.Headers.AUTHORIZATION
import work.socialhub.kmastodon.util.MediaType

class ReportsResourceImpl(
    uri: String,
    accessToken: String
) : AbstractAuthResourceImpl(uri, accessToken),
    ReportsResource {

    override fun reports(
    ): Response<Array<ReportsReportsResponse>> = exec {
        HttpRequest()
            .url("${uri}/api/v1/reports")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)
            .get()
    }

    override fun postReport(
        request: ReportsPostReportRequest
    ): Response<ReportsPostReportResponse> = exec {
        HttpRequest()
            .url("${uri}/api/v1/reports")
            .header(AUTHORIZATION, bearerToken())
            .accept(MediaType.JSON)

            .pwn("comment", request.comment)
            .pwn("account_id", request.accountId)
            .pwns("status_ids", request.statusIds)
            .post()
    }
}
