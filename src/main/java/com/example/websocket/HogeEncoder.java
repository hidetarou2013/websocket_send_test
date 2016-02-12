package com.example.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class HogeEncoder implements Encoder.Text<Hoge>{

	public HogeEncoder(){
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("init");
	}

	@Override
	public String encode(Hoge hoge) throws EncodeException {
		// TODO 自動生成されたメソッド・スタブ
        System.out.println("encode");
        return hoge.id + ":" + hoge.name;
	}

}
