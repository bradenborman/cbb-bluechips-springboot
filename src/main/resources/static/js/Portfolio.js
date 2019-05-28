$(document).ready(function(){
   var d = new Date();
	var n = d.toLocaleTimeString();
	document.getElementById("dateTime").innerHTML = d.toDateString() + " " + n

    $(".logo").click(function(){
         location.href = "trade/" + this.id
    });

     $(".tradeBTN").click(function(){
             var id = this.id.replace('btn','');
             location.href = "trade/" + id
        });

});
