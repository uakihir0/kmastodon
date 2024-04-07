package work.socialhub.kmastodon.streaming;

import java.io.Closeable;

/**
 *
 * @author hecateball
 */
public interface EventStream extends Closeable {

    public void open();

}
