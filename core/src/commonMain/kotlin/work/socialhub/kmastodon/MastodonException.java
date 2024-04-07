package work.socialhub.kmastodon;


import mastodon4j.entity.Error;

public class MastodonException extends RuntimeException {

    private Error error;
    private int statusCode;

    public MastodonException(Exception e) {
        super(e);
    }

    public MastodonException(Error error, int statusCode) {
        this.statusCode = statusCode;
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
