$(function() {
    $('#hoge').on('click', function() {
        var ws = new WebSocket('ws://localhost:8080/websocket_send_test/pathparam/hoge/11');
        ws.onopen = function() {
            ws.send('hoge message');
            ws.close();
        };
    });

    $('#fuga').on('click', function() {
        var ws = new WebSocket('ws://localhost:8080/websocket_send_test/pathparam/fuga/22');
        ws.onopen = function() {
            ws.send('fuga message');
            ws.close();
        };
    });
});