package work.socialhub.kmastodon.internal;

import com.google.gson.Gson;
import mastodon4j.MastodonException;
import mastodon4j.entity.Notification;
import mastodon4j.entity.Status;
import mastodon4j.streaming.LifeCycleListener;
import mastodon4j.streaming.UserStream;
import mastodon4j.streaming.UserStreamListener;
import net.socialhub.http.HttpRequestBuilder;
import net.socialhub.http.HttpResponse;
import net.socialhub.logger.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author hecateball
 */
final class _UserStream implements UserStream {

    private static final Logger LOGGER = Logger.getLogger(_UserStream.class);

    private final HttpRequestBuilder builder;
    private LifeCycleListener lifeCycle;
    private _StreamEvent streamEvent;
    private Thread thread;
    private boolean isOpen = false;
    private final Gson gson;

    _UserStream(HttpRequestBuilder builder) {
        this.builder = builder;
        this.gson = _InternalUtility.getGsonInstance();
    }

    @Override
    public UserStream register(UserStreamListener listener, LifeCycleListener lifeCycle) {
        this.streamEvent = new _StreamEvent((event) -> {

            switch (event.getName()) {
                case "update":
                    listener.onUpdate(gson.fromJson(event.getData(), Status.class));
                    break;
                case "notification":
                    listener.onNotification(gson.fromJson(event.getData(), Notification.class));
                    break;
                case "delete":
                    listener.onDelete(gson.fromJson(event.getData(), Long.class));
                    break;
                default:
                    LOGGER.debug("Unexpected event name: " + event.getName());
            }
        });
        this.lifeCycle = lifeCycle;
        return this;
    }

    @Override
    public void open() {
        if (!isOpen) {
            thread = new Thread(() -> {
                try {
                    HttpResponse response = builder.get();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.asStream(), "UTF-8"));
                    if (lifeCycle != null) {
                        lifeCycle.onConnect();
                    }
                    String line;

                    do {
                        line = reader.readLine();
                        this.streamEvent.add(line);
                        Thread.sleep(100);
                    } while (line != null);

                } catch (InterruptedException e) {
                    isOpen = false;
                    // close connection
                    if (lifeCycle != null) {
                        lifeCycle.onDisconnect();
                    }

                } catch (Exception e) {
                    isOpen = false;
                    // http exception
                    if (lifeCycle != null) {
                        lifeCycle.onDisconnect();
                    }
                    throw new MastodonException(e);
                }
            });
            thread.start();
            isOpen = true;
        }
    }

    @Override
    public void close() {
        if (isOpen) {
            thread.interrupt();
            isOpen = false;
        }
    }
}
