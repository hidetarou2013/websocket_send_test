$(function() {
    $('#send').attr('disabled', true);
    var ws = new WebSocket('ws://localhost:8080/websocket_send_test/broadcast');

    ws.onopen = function() {
        $('#send').attr('disabled', false);
    };

    ws.onmessage = function(receive) {
        $('#receive').text(receive.data);
    };

    $('#send').on('click', function() {
        var sendMessage = $('#message').val();
        ws.send(sendMessage);
    });
});
