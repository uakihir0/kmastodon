package work.socialhub.kmastodon.streaming;

public interface LifeCycleListener {

    void onConnect();

    void onDisconnect();
}
