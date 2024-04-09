package work.socialhub.kmastodon

class MastodonException : Exception {
    var statusCode: Int? = null
    var body: String? = null

    constructor(e: Exception) : super(e)

    constructor(statusCode: Int, body: String) {
        this.statusCode = statusCode
        this.body = body
    }
}
