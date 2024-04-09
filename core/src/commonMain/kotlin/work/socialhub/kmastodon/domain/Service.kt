package work.socialhub.kmastodon.domain

enum class Service {
    MASTODON,
    PIXELFED,
    PLEROMA,
    ;

    companion object {
        fun from(value: String): Service {
            return entries.toTypedArray()
                .find { it.name.equals(value, ignoreCase = true) }
                ?: throw IllegalStateException("unsupported service: $value")
        }
    }
}
