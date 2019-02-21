var clickCounter=0;
const Http = new XMLHttpRequest();
$('.field').click(function() {
    put (this.id);
});


function put (move)
{
    clickCounter++;
    if (clickCounter%2==0) {
        $('#'+move).removeClass('field').addClass('field-o').off();
    }   else {
        $('#'+move).removeClass('field').addClass('field-x').off();
    }
    var playerId=clickCounter%2;
    var url = "http://localhost:8080/clickevent?move="+move+"&playerId="+playerId;
    Http.open("GET",url);
    Http.send();
}
