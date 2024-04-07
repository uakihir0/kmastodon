package work.socialhub.kmastodon.domain;

import java.util.Arrays;

public enum Service {
    MASTODON,
    PIXELFED,
    PLEROMA,
    ;

    public static Service from(String value) {
        return Arrays.stream(Service.values()).filter(e ->
                e.name().equalsIgnoreCase(value)
        ).findFirst().orElseThrow(() ->
                new IllegalStateException("unsupported service: " + value)
        );
    }
}
