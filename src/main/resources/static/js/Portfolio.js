$(document).ready(function(){
   var d = new Date();
	var n = d.toLocaleTimeString();

    var dateTimeEle = document.getElementById("dateTime");
    if(dateTimeEle != null) {
        dateTimeEle.innerHTML = d.toDateString() + " " + n
    }

    $(".logo").click(function(){
         location.href = "trade/" + this.id
    });

     $(".tradeBTN").click(function(){
             var id = this.id.replace('btn','');
             location.href = "trade/" + id
        });

    $('#logoutLink').click(function(event) {
        event.preventDefault();
        document.getElementById("logoutForm").submit();
    });


});
