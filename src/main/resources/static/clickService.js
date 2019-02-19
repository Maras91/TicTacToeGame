var clickCounter=0;
const Http = new XMLHttpRequest();
$('.field').click(function() {
    put (this.id);
});


function put (move)
{
    clickCounter++;
    if (clickCounter%2==0) {
        $('#'+move).removeClass('field').addClass('field-o');
    }   else {
        $('#'+move).removeClass('field').addClass('field-x');
    }
    var playerId=clickCounter%2;
    var url = "http://localhost:8080/home?move="+move+"&playerId="+playerId;
    Http.open("GET",url);
    Http.send();

}
