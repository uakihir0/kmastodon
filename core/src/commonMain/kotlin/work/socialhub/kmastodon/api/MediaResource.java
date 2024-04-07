package work.socialhub.kmastodon.api;

import mastodon4j.entity.Attachment;
import mastodon4j.entity.share.Response;

import java.io.File;
import java.io.InputStream;

/**
 * @author hecateball
 */
public interface MediaResource {

    /**
     * Uploading a media attachment.
     *
     * @param stream      input stream (media to be uploaded)
     * @param name        file name that uploading
     * @param description description of media
     * @return an Attachment that can be used when creating a status
     */
    public Response<Attachment> postMedia(InputStream stream, String name, String description);


    /**
     * Uploading a media attachment.
     *
     * @param file        file (media to be uploaded)
     * @param description description of media
     * @return an Attachment that can be used when creating a status
     */
    public Response<Attachment> postMedia(File file, String description);
}
