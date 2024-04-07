package work.socialhub.kmastodon.internal;

import net.socialhub.logger.Logger;

import java.util.function.Consumer;

public class _StreamEvent {

    private static final Logger LOGGER = Logger.getLogger(_StreamEvent.class);

    private final Consumer<_StreamModel> consumer;

    private _StreamModel event;

    _StreamEvent(Consumer<_StreamModel> consumer) {
        this.consumer = consumer;
    }

    public void add(String line) {
        String trim = line.trim();

        // nop event
        if (trim.equals(":thump")) {
            event = null;
            return;
        }

        // check event
        if (trim.startsWith("event")) {
            String[] events = trim.split(":");

            if (events.length == 2) {
                event = new _StreamModel();
                event.setName(events[1].trim());
            }
            return;
        }

        // data event
        if (trim.startsWith("data")) {

            int end = trim.length();
            int start = trim.indexOf(":") + 1;
            String data = trim.substring(start, end);

            event.setData(data.trim());
            LOGGER.debug(event.getData());
            consumer.accept(event);
            event = null;
            return;
        }
    }

    public static class _StreamModel {

        private String name;
        private String data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
