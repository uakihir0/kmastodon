package work.socialhub.kmastodon.entity.share;

import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author uakihir0
 */
public class RateLimit {

    private static final Logger logger = Logger.getLogger(RateLimit.class);

    private static final String X_RATELIMIT_LIMIT = "X-RateLimit-Limit";

    private static final String X_RATELIMIT_REMAINING = "X-RateLimit-Remaining";

    private static final String X_RATELIMIT_RESET = "X-RateLimit-Reset";

    private int limit;
    private int remaining;
    private Date reset;

    public static RateLimit of(HttpResponse response) {
        if (response == null) {
            return null;
        }

        try {
            String limit = response.getResponseHeader(X_RATELIMIT_LIMIT);
            String remaining = response.getResponseHeader(X_RATELIMIT_REMAINING);
            String reset = response.getResponseHeader(X_RATELIMIT_RESET);

            RateLimit rateLimit = new RateLimit();
            rateLimit.setLimit(new Integer(limit));
            rateLimit.setRemaining(new Integer(remaining));

            String[] dates = reset.split("\\.");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            rateLimit.setReset(format.parse(dates[0]));

            return rateLimit;

        } catch (Exception e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Date getReset() {
        return reset;
    }

    public void setReset(Date reset) {
        this.reset = reset;
    }
}
