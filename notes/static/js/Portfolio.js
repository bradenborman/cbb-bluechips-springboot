$(document).ready(function() {
  var d = new Date();
  var n = d.toLocaleTimeString();

  var token = $('meta[name="_csrf"]').attr("content");
  $.ajaxSetup({
    headers: { "X-CSRF-TOKEN": token }
  });

  $('[data-toggle="tooltip"]').tooltip();

  var dateTimeEle = document.getElementById("dateTime");
  if (dateTimeEle != null) {
    dateTimeEle.innerHTML = d.toDateString() + " " + n;
  }

  $(".logo").click(function() {
    location.href = "trade/" + this.id;
  });

  $(".tradeBTN").click(function() {
    var id = this.id.replace("btn", "");
    location.href = "trade/" + id;
  });

  $("#logoutLink").click(function(event) {
    event.preventDefault();
    document.getElementById("logoutForm").submit();
  });
});

function sellAllAction() {
  $("#sellAllTeamsBtn").hide();
  $("#sellAllLoadingTxt").show();

  $.post("/trade/sell-all", {}, function(data, status) {
    window.location.href = "/";
  });
}
