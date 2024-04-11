package work.socialhub.kmastodon.stream.listener

import work.socialhub.kmastodon.stream.listener.primitive.DeleteEventListener
import work.socialhub.kmastodon.stream.listener.primitive.UpdateEventListener

interface HashtagStreamListener : UpdateEventListener, DeleteEventListener
