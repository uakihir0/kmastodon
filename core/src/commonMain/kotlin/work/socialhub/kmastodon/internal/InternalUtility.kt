package work.socialhub.kmastodon.internal

import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kmpcommon.AnySerializer

object InternalUtility {

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        serializersModule = SerializersModule {
            contextual(Any::class, AnySerializer)
        }
    }

    inline fun <reified T> toJson(obj: T): String {
        return json.encodeToString(obj)
    }

    inline fun <reified T> fromJson(obj: String): T {
        return json.decodeFromString(obj)
    }
}
