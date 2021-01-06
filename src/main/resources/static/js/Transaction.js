$(document).ready(function(){


});

function addSearchTag() {
    var tagValue = $('#tagInput').val().trim().toUpperCase()
    if(tagValue == "" || tagValue == null)
        return;

    const urlParams = new URLSearchParams(window.location.search);
    if(!urlParams.has('params'))
    {
        window.location.replace("/transactions?params="+ tagValue)
    }else {
        window.location.replace("/transactions?" + urlParams + "<->" + tagValue)
    }

}

function appendNewRow(name, action, team, amount, date) {
    $('#myTable tr:last').after('<tr><td>' + name + '</td><td>' + getTradeActionLabel(action) + '</td><td>' + team + '</td><td>$' + ReplaceNumberWithCommas(amount) + '</td><td>' + date + '</td></tr>');
}

function removeTag(paramsToDrop) {
    const urlParams = new URLSearchParams(window.location.search);
    const includesMulitpleParams = urlParams.get('params').includes("<->")

    if(includesMulitpleParams)
    {
        var newParams = window.location.search
        .replace("<->" + paramsToDrop, "")
        .replace("%3C-%3E" + paramsToDrop, "")
        .replace(paramsToDrop, "")

        window.location.replace("/transactions" + newParams.replace("params=<->", "params=").replace("params=%3C-%3E", "params="))
    }
    else
    {
            urlParams.forEach(function(value, key) {
              if(value == paramsToDrop)
                    urlParams.delete(key)
            });
            window.location.replace("/transactions?" + urlParams)
    }

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