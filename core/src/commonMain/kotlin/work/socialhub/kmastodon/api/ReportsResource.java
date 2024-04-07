package work.socialhub.kmastodon.api;

import mastodon4j.entity.Report;
import mastodon4j.entity.share.Response;

/**
 * @author hecateball
 */
public interface ReportsResource {

    /**
     * Fetching a user's reports.
     *
     * @return a list of Reports made by the authenticated user
     */
    public Response<Report[]> getReports();

    /**
     * Reporting a user.
     *
     * @param accountId
     * @param statusIds
     * @param comment
     * @return the finished Report
     */
    public Response<Report> postReport(String accountId, String[] statusIds, String comment);
}
