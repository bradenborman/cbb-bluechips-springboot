$(document).ready(function(){
   var d = new Date();
	var n = d.toLocaleTimeString();
	document.getElementById("dateTime").innerHTML = d.toDateString() + " " + n

});

//TODO
function goToTradeCentral(teamID) {
	window.location.href = "../trade/?team=" + teamID;
}