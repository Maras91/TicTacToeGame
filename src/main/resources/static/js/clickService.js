var clickCounter=0;
const Http = new XMLHttpRequest();
$('.field').click(function() {
    put (this.id);
});


function put (move)
{
    clickCounter++;
    var playerId=clickCounter%2;
    $.post( "/clickevent",{move:move,playerId:playerId},function( response ) {
    var jsonResponse = JSON.parse(response)
    var isWin = jsonResponse.playerWin;
    var playerWin = jsonResponse.whichPlayerWon;
    var board = jsonResponse.board;
    displayMoves(board);
    if (isWin) {
        displayWinMessage(playerWin);
    }
    });
    function displayWinMessage(player) {
        $('.fields').html('<h1>Player "'+player+'" win!!!</h1>')
    }
    function displayMoves(board) {
        var xMoves = board.x;
        var oMoves = board.o;
        for (i = 0; i < xMoves.length; i++) {
            var id = xMoves[i].yAxis.toString()+xMoves[i].xAxis.toString();
            if ($('#'+id).hasClass('field')) {
                $('#'+id).removeClass('field').addClass('field-x').off();
            }
        }
        for (i = 0; i < oMoves.length; i++) {
            var id = oMoves[i].yAxis.toString()+oMoves[i].xAxis.toString();
            if ($('#'+id).hasClass('field')) {
                $('#'+id).removeClass('field').addClass('field-o').off();
            }
        }
    }
}
