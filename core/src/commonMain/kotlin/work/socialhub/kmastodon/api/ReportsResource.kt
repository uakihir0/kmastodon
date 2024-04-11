package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.reports.ReportsPostReportRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.reports.ReportsPostReportResponse
import work.socialhub.kmastodon.api.response.reports.ReportsReportsResponse
import kotlin.js.JsExport

@JsExport
interface ReportsResource {

    /**
     * Fetching a user's reports.
     */
    fun reports(
    ): Response<Array<ReportsReportsResponse>>

    /**
     * Reporting a user.
     */
    fun postReport(
        request: ReportsPostReportRequest
    ): Response<ReportsPostReportResponse>
}
