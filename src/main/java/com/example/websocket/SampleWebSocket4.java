package com.example.websocket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadcast")
/**
 * http://qiita.com/opengl-8080/items/7ca8484c8579d264e239
 *
 * @author maekawa
 *
 */
public class SampleWebSocket4 {

	@OnMessage
    public void broadcast(String message, Session session) throws IOException {
        session.getOpenSessions().forEach(s -> {
            s.getAsyncRemote().sendText(message);
        });
    }
}
