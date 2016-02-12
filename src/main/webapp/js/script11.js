$(function() {
    var ws = new WebSocket('ws://localhost:8080/websocket_send_test/decode');

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