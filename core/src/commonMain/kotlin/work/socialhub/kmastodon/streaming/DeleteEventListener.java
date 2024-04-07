package work.socialhub.kmastodon.streaming;

/**
 *
 * @author hecateball
 */
public interface DeleteEventListener {

    default public void onDelete(long id) {
    }
}
