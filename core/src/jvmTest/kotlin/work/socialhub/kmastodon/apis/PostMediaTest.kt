package work.socialhub.kmastodon.apis

import kotlinx.coroutines.test.runTest
import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.medias.MediasPostMediaRequest
import kotlin.test.Test
import kotlin.test.assertNotNull

class PostMediaTest : AbstractTest() {

    @Test
    fun testMedia() = runTest {
        val stream = javaClass.getResourceAsStream("/icon.png")

        val response = mastodon().medias().postMedia(
            MediasPostMediaRequest().also {
                it.bytes = stream.readAllBytes()
                it.name = "icon.png"
            }
        )

        assertNotNull(response.data.id)
        println(response.data.id)
    }
}
