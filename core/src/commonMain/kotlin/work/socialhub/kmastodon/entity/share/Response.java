package work.socialhub.kmastodon.entity.share;

/**
 * @author uakihir0
 */
public class Response<T> {

    private T object;

    private RateLimit limit;

    private Link link;

    public T get() {
        return object;
    }

    public void set(T object) {
        this.object = object;
    }

    public RateLimit getRateLimit() {
        return limit;
    }

    public void setRateLimit(RateLimit limit) {
        this.limit = limit;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
