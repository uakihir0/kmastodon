package work.socialhub.kmastodon.stream.listener

import work.socialhub.kmastodon.stream.listener.primitive.DeleteEventListener
import work.socialhub.kmastodon.stream.listener.primitive.NotificationEventListener
import work.socialhub.kmastodon.stream.listener.primitive.UpdateEventListener

interface UserStreamListener : UpdateEventListener, NotificationEventListener, DeleteEventListener
