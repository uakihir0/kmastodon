package work.socialhub.kmastodon

import work.socialhub.kmastodon.domain.Service
import kotlin.test.Test
import kotlin.test.assertEquals

class ServiceTest {

    @Test
    fun testKnownSoftware() {
        assertEquals(Service.MASTODON, Service.from("mastodon"))
        assertEquals(Service.MASTODON, Service.from("Mastodon"))
        assertEquals(Service.MASTODON, Service.from("hometown"))
        assertEquals(Service.PIXELFED, Service.from("pixelfed"))
        assertEquals(Service.PLEROMA, Service.from("pleroma"))
        assertEquals(Service.AKKOMA, Service.from("akkoma"))
        assertEquals(Service.GOTOSOCIAL, Service.from("gotosocial"))
        assertEquals(Service.FIREFISH, Service.from("firefish"))
        assertEquals(Service.FIREFISH, Service.from("calckey"))
        assertEquals(Service.ICESHRIMP, Service.from("iceshrimp"))
        assertEquals(Service.ICESHRIMP, Service.from("iceshrimp.net"))
        assertEquals(Service.FRIENDICA, Service.from("friendica"))
    }

    @Test
    fun testUnknownSoftwareDoesNotThrow() {
        // Must not throw: unknown software falls back to OTHER.
        assertEquals(Service.OTHER, Service.from("something-new"))
        assertEquals(Service.OTHER, Service.from(""))
    }
}
