$(document).ready(function(){

	$("#Networth").html("$" + ReplaceNumberWithCommas(networth));
	$("#Leader").html("$" + ReplaceNumberWithCommas(leader));
	$("#TotalMoney").html("$" + ReplaceNumberWithCommas(totalMoney));
	$("#CurrentRound").html(currentRound);

   var d = new Date();
	var n = d.toLocaleTimeString();
	document.getElementById("dateTime").innerHTML = d.toDateString() + " " + n

});




//TODO
function goToTradeCentral(teamID) {
	window.location.href = "../trade/?team=" + teamID;
}


//TODO replace with load in as
function ReplaceNumberWithCommas(yourNumber) {
    var n= yourNumber.toString().split(".");
    n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return n.join(".");
}