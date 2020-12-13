$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().trim().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });


    $(function(){
        $("tbody").each(function(elem,index){
          var arr = $.makeArray($("tr",this).detach());
          arr.reverse();
            $(this).append(arr);
        });
    });

    setTimeout(function(){
            $.get("/data/remainingTransactions", function(data, status){
                $.each(data, function(key, value){
                        appendNewRow(value.fullName, value.tradeAction, value.teamName, value.cashTraded, value.strTimeofTransaction);
                });
            });
     }, 1000);

});


function appendNewRow(name, action, team, amount, date) {
    $('#myTable tr:last').after('<tr><td>' + name + '</td><td>' + getTradeActionLabel(action) + '</td><td>' + team + '</td><td>$' + ReplaceNumberWithCommas(amount) + '</td><td>' + date + '</td></tr>');
}

function getTradeActionLabel(action) {
    if(action == "BUY")
        return "<span class='badge-primary badge'>" + action + "</span>";
    else
        return "<span class='badge-success badge'>" + action + "</span>";
}

function ReplaceNumberWithCommas(yourNumber) {
    var n= yourNumber.toString().split(".");
    n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return n.join(".");
}