package work.socialhub.kmastodon.api

import mastodon4j.entity.Report
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface ReportsResource {
    /**
     * Fetching a user's reports.
     *
     * @return a list of Reports made by the authenticated user
     */
    val reports: Response<Array<Report?>?>?

    /**
     * Reporting a user.
     *
     * @param accountId
     * @param statusIds
     * @param comment
     * @return the finished Report
     */
    fun postReport(accountId: String?, statusIds: Array<String?>?, comment: String?): Response<Report?>?
}
