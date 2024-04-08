package work.socialhub.kmastodon


import mastodon4j.entity.Error

class MastodonException : java.lang.RuntimeException {
    private var error: java.lang.Error? = null
    var statusCode: Int = 0
        private set

    constructor(e: java.lang.Exception?) : super(e)

    constructor(error: java.lang.Error?, statusCode: Int) {
        this.statusCode = statusCode
        this.error = error
    }

    fun getError(): java.lang.Error? {
        return error
    }
}
