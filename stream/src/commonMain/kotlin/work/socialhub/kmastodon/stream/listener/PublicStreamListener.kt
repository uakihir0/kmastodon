package work.socialhub.kmastodon.stream.listener

import work.socialhub.kmastodon.stream.listener.primitive.DeleteEventListener
import work.socialhub.kmastodon.stream.listener.primitive.UpdateEventListener

interface PublicStreamListener : UpdateEventListener, DeleteEventListener
