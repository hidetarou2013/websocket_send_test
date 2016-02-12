package com.example.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class HogeDecoder implements Decoder.Text<Hoge>{

	public HogeDecoder(){
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
	public Hoge decode(String s) throws DecodeException {
		// TODO 自動生成されたメソッド・スタブ
        System.out.println("decode");

        String[] tokens = s.split(":");

        Hoge hoge = new Hoge();
        hoge.id = Integer.parseInt(tokens[0]);
        hoge.name = tokens[1];

//        try {
////			hoge.name = tokens[1].getBytes("UTF8").toString();
////			hoge.name = new String(tokens[1].getBytes("UTF8"),"UTF8");
//        	byte[] tmp = tokens[1].getBytes("UTF8");
//        	byte[] tmp2 = new byte[tmp.length-1];
//        	for(int i = 0 ; i < tmp.length-2 ; i++){
//        		tmp2[i] = tmp[i];
//        	}
//        	hoge.name = new String(tmp2,"UTF8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

        return hoge;
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("willDecode");
        return true;
	}

}
