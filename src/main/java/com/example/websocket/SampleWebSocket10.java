package com.example.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadcast2")
/**
 * http://qiita.com/opengl-8080/items/7ca8484c8579d264e239
 *
 * @author maekawa
 *
 */
public class SampleWebSocket10 {

	private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    static {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(SampleWebSocket10::broadcast2, 5, 5, TimeUnit.SECONDS);
    }

    @OnOpen
    public void connect(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void remove(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable cause) {
        System.out.println("error : " + session.getId() + ", " + cause.getMessage());
    }

    public static void broadcast2() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        sessions.forEach(session -> {
            session.getAsyncRemote().sendText("Broadcast : " + formatter.format(now));
        });
    }
}
