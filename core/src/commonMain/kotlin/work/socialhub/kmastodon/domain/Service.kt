package work.socialhub.kmastodon.domain

enum class Service {
    MASTODON,
    PIXELFED,
    PLEROMA,
    ;

    companion object {
        fun from(value: String): Service {
            return java.util.Arrays.stream(entries.toTypedArray()).filter(
                java.util.function.Predicate<Service> { e: Service -> e.name.equals(value, ignoreCase = true) }
            ).findFirst().orElseThrow<java.lang.IllegalStateException>(
                java.util.function.Supplier<java.lang.IllegalStateException> { java.lang.IllegalStateException("unsupported service: $value") }
            )
        }
    }
}
