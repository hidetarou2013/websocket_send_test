$(function() {
    var ws = new WebSocket('ws://localhost:8080/websocket_send_test/broadcast2');

    ws.onmessage = function(e) {
        $('#message').text(e.data);
    };
});