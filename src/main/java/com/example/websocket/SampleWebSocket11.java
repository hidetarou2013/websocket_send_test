package com.example.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/decode", decoders=HogeDecoder.class)
/**
 * http://qiita.com/opengl-8080/items/7ca8484c8579d264e239
 *
 * @author maekawa
 *
 */
public class SampleWebSocket11 {

    @OnMessage
    public void message(Hoge hoge) {
        System.out.println(hoge);
    }
}
