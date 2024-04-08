package work.socialhub.kmastodon

class Page {
    private var offset: java.util.Optional<Long>
    private var limit: java.util.Optional<Long>

    init {
        this.offset = java.util.Optional.empty<Long>()
        this.limit = java.util.Optional.empty<Long>()
    }

    fun getOffset(): java.util.Optional<Long> {
        return offset
    }

    fun setOffset(offset: Long) {
        this.offset = java.util.Optional.of<Long>(offset)
    }

    fun getLimit(): java.util.Optional<Long> {
        return limit
    }

    fun setLimit(limit: Long) {
        this.limit = java.util.Optional.of<Long>(limit)
    }
}
