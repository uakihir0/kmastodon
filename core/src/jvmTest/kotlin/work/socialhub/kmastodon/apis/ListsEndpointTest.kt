package work.socialhub.kmastodon.apis

import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress
import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.MastodonFactory
import work.socialhub.kmastodon.api.request.lists.ListsListsRequest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListsEndpointTest {

    @Test
    fun differentiatesOwnedAndContainingAccountLists() = runTest {
        val requestedPaths = mutableListOf<String>()
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        server.createContext("/") { exchange ->
            requestedPaths.add(exchange.requestURI.path)
            val body = """[{"id":"list-id","title":"List"}]""".encodeToByteArray()
            exchange.responseHeaders.add("Content-Type", "application/json")
            exchange.sendResponseHeaders(200, body.size.toLong())
            exchange.responseBody.use { it.write(body) }
        }
        server.start()

        try {
            val lists = MastodonFactory.instance(
                "http://127.0.0.1:${server.address.port}",
                "access-token",
            ).lists()

            assertEquals("list-id", lists.ownedLists().data.single().id)
            assertEquals(
                "list-id",
                lists.lists(
                    ListsListsRequest().also { it.id = "account-id" }
                ).data.single().id,
            )
            assertEquals(
                listOf(
                    "/api/v1/lists",
                    "/api/v1/accounts/account-id/lists",
                ),
                requestedPaths,
            )
        } finally {
            server.stop(0)
        }
    }
}
