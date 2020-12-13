function updateBuyBTN(value) {
      updateSpent(value, "BUY")
      $("#buyBTN").html("Buy: " + value);
}


    function updateSellBTN(value) {
        updateSpent(value, "SELL")
        $("#sellBTN").html("Sell: " + value);
 }


function updateSpent(value, action) {
	  var y = $("#costPerShare").text()
	  var cost = y.replace(/\D+/g, '');
	var spent = value * cost
	$('#totalSpent').html("$" + ReplaceNumberWithCommas(spent))
}


function ReplaceNumberWithCommas(yourNumber) {
    var n= yourNumber.toString().split(".");
    n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return n.join(".");
}