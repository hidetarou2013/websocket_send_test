# はじめに

## ■■JavaScript（クライアント）とJava（サーバ）の間ででWebSocketしてsendした時、OnMessageで文字化ける

動作環境
- OS：Windows7 64bit
- IDE:pleiades-e4.5
- JDK:1.8
- Tomcat:Tomcat8
- javax.websocket-api:1.1

GitHub
https://github.com/hidetarou2013/websocket_send_test

git clone URL

```
git clone git@github.com:hidetarou2013/websocket_send_test.git
```

eclipse4.5+Tomcat8環境で実行時の対象アプリケーションのURL
http://localhost:8080/websocket_send_test/index11.jsp


### ■送信処理部：クライアント側のjsファイル
UTF8　BOMなしで保存

```
$(function() {
    var ws = new WebSocket('ws://localhost:8080/jaxrs-sample/decode');

    ws.onopen = function(e) {
        $('#send').on('click', function() {
            //ws.send('12:HogeHoge');// 問題なし
            ws.send('12:ほげ');      // 文字化けてしまう。
        });

        $('#close').on('click', function() {
            ws.close();
        });
    };
});
```

### ■受信部：サーバ側のDecoderクラスのdecodeメソッド

```
	@Override
	public Hoge decode(String s) throws DecodeException {
		// TODO 自動生成されたメソッド・スタブ
        System.out.println("decode");

        String[] tokens = s.split(":");

        Hoge hoge = new Hoge();
        hoge.id = Integer.parseInt(tokens[0]);
        hoge.name = tokens[1];

        return hoge;
	}
```
	
### ■@ServerEndpoint(value="/decode", decoders=HogeDecoder.class)なクラスの「@OnMessage」メソッド部分
	
```
    @OnMessage
    public void message(Hoge hoge) {
        System.out.println(hoge);
    }
```
    
### ■結果：コンソールログ

```
init
willDecode
decode
Hoge [id=12, name = ã»ã’]
```

----

どうしても文字化けしてしまう。。

hoge.name = new String(tokens[1].getBytes("UTF8"),"UTF8");

としても、結果は改善せず。



