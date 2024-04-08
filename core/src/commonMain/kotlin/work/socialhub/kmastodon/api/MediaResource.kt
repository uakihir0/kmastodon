package work.socialhub.kmastodon.api

import mastodon4j.entity.Attachment
import mastodon4j.entity.share.Response

/**
 * @author hecateball
 */
interface MediaResource {
    /**
     * Uploading a media attachment.
     *
     * @param stream      input stream (media to be uploaded)
     * @param name        file name that uploading
     * @param description description of media
     * @return an Attachment that can be used when creating a status
     */
    fun postMedia(stream: java.io.InputStream?, name: String?, description: String?): Response<Attachment?>?


    /**
     * Uploading a media attachment.
     *
     * @param file        file (media to be uploaded)
     * @param description description of media
     * @return an Attachment that can be used when creating a status
     */
    fun postMedia(file: java.io.File?, description: String?): Response<Attachment?>?
}
