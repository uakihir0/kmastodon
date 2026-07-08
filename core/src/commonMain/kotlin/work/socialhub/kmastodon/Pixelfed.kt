package work.socialhub.kmastodon

import work.socialhub.kmastodon.api.CollectionsResource
import work.socialhub.kmastodon.api.StoriesResource
import kotlin.js.JsExport

/**
 * Pixelfed client. Extends [Mastodon] with Pixelfed-specific resources;
 * all standard Mastodon resources remain available.
 */
@JsExport
interface Pixelfed : Mastodon {

    fun stories(): StoriesResource

    fun collections(): CollectionsResource
}
