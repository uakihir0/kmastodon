package work.socialhub.kmastodon.domain

import kotlin.js.JsExport

@JsExport
enum class Service {
    MASTODON,
    PIXELFED,
    PLEROMA,
    AKKOMA,
    GOTOSOCIAL,
    FIREFISH,
    ICESHRIMP,
    FRIENDICA,

    /** Mastodon-compatible software that is not otherwise recognized. */
    OTHER,
    ;

    companion object {
        /**
         * Resolve a [Service] from a NodeInfo "software.name" value.
         * Never throws: unknown software falls back to [OTHER] so that
         * Mastodon-compatible forks keep working with the default behavior.
         */
        fun from(value: String): Service {
            return when (value.trim().lowercase()) {
                "mastodon", "hometown", "glitch-soc" -> MASTODON
                "pixelfed" -> PIXELFED
                "pleroma" -> PLEROMA
                "akkoma" -> AKKOMA
                "gotosocial" -> GOTOSOCIAL
                "firefish", "calckey" -> FIREFISH
                "iceshrimp", "iceshrimp.net" -> ICESHRIMP
                "friendica" -> FRIENDICA
                else -> OTHER
            }
        }
    }
}
