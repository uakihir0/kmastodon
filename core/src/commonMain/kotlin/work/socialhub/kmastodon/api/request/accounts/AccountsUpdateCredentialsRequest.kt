package work.socialhub.kmastodon.api.request.accounts

import kotlin.js.JsExport

@JsExport
class AccountsUpdateCredentialsRequest {
    var displayName: String? = null
    var note: String? = null

    // Avatar image, encoded using multipart/form-data.
    var avatar: ByteArray? = null
    var avatarName: String? = null

    // Header image, encoded using multipart/form-data.
    var header: ByteArray? = null
    var headerName: String? = null
}
