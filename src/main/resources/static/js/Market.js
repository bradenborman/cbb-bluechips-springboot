$(document).ready(function(){

    $(".overunder").each(function() {
       if($(this).text() >= 1) {
            $(this).parents("div").prop('title', '- UNDERDOG -');
            $(this).css("color", "green");
      }
       else {
            $(this).parents("div").prop('title', '- FAVORITE -');
            $(this).css("color", "red");
      }
    });

    setTimeout(function(){ drawChart(15, 100) }, 1500);

    var toInsert = $('.col-lg-6').eq(11);
    var div = $('#addsPlaceholder').html()
    $(div).insertAfter(toInsert);

$('.float-nav').click(function() {
  $('.main-nav, .menu-btn').toggleClass('active');
});

});