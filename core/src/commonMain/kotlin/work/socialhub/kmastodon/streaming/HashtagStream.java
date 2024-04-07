package work.socialhub.kmastodon.streaming;

/**
 *
 * @author hecateball
 */
public interface HashtagStream extends EventStream {

    public HashtagStream register(HashtagStreamListener listener, LifeCycleListener lifeCycle);
}
