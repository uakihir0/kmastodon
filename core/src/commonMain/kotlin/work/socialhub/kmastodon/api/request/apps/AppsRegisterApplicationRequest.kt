package work.socialhub.kmastodon.api.request.apps

import kotlin.js.JsExport

@JsExport
class AppsRegisterApplicationRequest {
    var name: String? = null
    var website: String? = null
    var redirectUris: String? = null
    var scopes: String? = null
}