package work.socialhub.kmastodon.apis

import work.socialhub.kmastodon.AbstractTest
import work.socialhub.kmastodon.api.request.medias.MediasPostMediaRequest
import kotlin.test.Test

class PostMediaTest : AbstractTest() {

    @Test
    fun testMedia() {
        val stream = javaClass.getResourceAsStream("/icon.png")

        val response = mastodon().medias().postMedia(
            MediasPostMediaRequest().also {
                it.bytes = stream.readAllBytes()
                it.name = "icon.png"
            }
        )

        println(response.data.id)
    }
}