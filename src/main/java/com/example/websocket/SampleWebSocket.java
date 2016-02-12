package com.example.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
/**
 * http://qiita.com/opengl-8080/items/7ca8484c8579d264e239
 *
 * @author maekawa
 *
 */
public class SampleWebSocket {

	@OnMessage
	public String echo(String message) {
		System.out.println(message);
		return message + "を受け取りました！";
	}

}
