$(function() {
    var ws = new WebSocket('ws://localhost:8080/websocket_send_test/encode');

    ws.onopen = function() {
        $('#send').on('click', function() {
            ws.send(null);
        });

        $('#close').on('click', function() {
            ws.close();
        });
    };

    ws.onmessage = function(e) {
        console.log(e.data);
    };

    ws.onmessage = function(receive) {
        $('#message').text(receive.data);
    };
});