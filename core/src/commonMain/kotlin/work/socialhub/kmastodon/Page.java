package work.socialhub.kmastodon;

import java.util.Optional;

public final class Page {

    private Optional<Long> offset;
    private Optional<Long> limit;

    public Page() {
        this.offset = Optional.empty();
        this.limit = Optional.empty();
    }

    public Optional<Long> getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = Optional.of(offset);
    }

    public Optional<Long> getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = Optional.of(limit);
    }
}
