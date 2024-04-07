package work.socialhub.kmastodon;

import java.util.Optional;

/**
 * @author hecateball
 */
public final class Range {

    private Optional<String> maxId;
    private Optional<String> minId;
    private Optional<String> sinceId;
    private Optional<Long> limit;

    public Range() {
        this.maxId = Optional.empty();
        this.minId = Optional.empty();
        this.sinceId = Optional.empty();
        this.limit = Optional.empty();
    }

    public Optional<String> getMaxId() {
        return maxId;
    }

    public void setMaxId(String maxId) {
        this.maxId = Optional.of(maxId);
    }

    public Optional<String> getMinId() {
        return minId;
    }

    public void setMinId(String minId) {
        this.minId = Optional.of(minId);
    }

    public Optional<String> getSinceId() {
        return sinceId;
    }

    public void setSinceId(String sinceId) {
        this.sinceId = Optional.of(sinceId);
    }

    public Optional<Long> getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = Optional.of(limit);
    }
}
