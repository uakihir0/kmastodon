package work.socialhub.kmastodon.streaming;

/**
 *
 * @author hecateball
 */
public interface UserStream extends EventStream {

    public UserStream register(UserStreamListener listener, LifeCycleListener lifeCycle);

}
