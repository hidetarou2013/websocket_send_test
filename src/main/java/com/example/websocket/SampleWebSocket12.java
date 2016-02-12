package com.example.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/encode", encoders=HogeEncoder.class)
/**
 * http://qiita.com/opengl-8080/items/7ca8484c8579d264e239
 *
 * @author maekawa
 *
 */
public class SampleWebSocket12 {

    @OnMessage
    public Hoge message(String message) {
        System.out.println("message");
        Hoge hoge = new Hoge();
        hoge.id = 20;
        hoge.name = "HOGE";

        return hoge;
    }
}
