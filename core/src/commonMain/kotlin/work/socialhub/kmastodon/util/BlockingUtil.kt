package work.socialhub.kmastodon.util

import kotlinx.coroutines.CoroutineScope

expect fun <T> toBlocking(block: suspend CoroutineScope.() -> T): T
