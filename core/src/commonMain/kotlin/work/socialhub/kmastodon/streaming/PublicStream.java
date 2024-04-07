package work.socialhub.kmastodon.streaming;

/**
 *
 * @author hecateball
 */
public interface PublicStream extends EventStream {

    public PublicStream register(PublicStreamListener listener, LifeCycleListener lifeCycle);
}
