package work.socialhub.kmastodon.api

import work.socialhub.kmastodon.api.request.apps.AppsRegisterApplicationRequest
import work.socialhub.kmastodon.api.response.Response
import work.socialhub.kmastodon.api.response.apps.AppsRegisterApplicationResponse
import kotlin.js.JsExport

@JsExport
interface AppsResource {

    /**
     * Registering an application.
     */
    fun registerApplication(
        request: AppsRegisterApplicationRequest
    ): Response<AppsRegisterApplicationResponse>
}
