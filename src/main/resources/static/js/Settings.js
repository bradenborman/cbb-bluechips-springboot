
   var defualt = [1, 1, 1, 1, 1]

    $(document).ready(function(){


     $('#textAlertCheck').change(function() {
        $.post("/settings/updateTextAlert",
        {
          textStatus: this.checked
        },
        function(data,status){
          console.log("Data: " + data + "\nStatus: " + status);
        });
    });

        $("#DELETE").hide()
        returnToDefualt()
        $(document).on({
            mouseenter: function() {
                var index_of_hovered = $(this).parent().children('.fa-star').index(this);
                $(".fa-star").removeClass("checked");
                for(var x = 0; x <= index_of_hovered; x++) {
                    $(".fa-star").eq(x).addClass("checked");
                }
            }
        }, ".fa-star");

        $(document).on({
            mouseleave: function() {
              returnToDefualt()
            }
        }, ".rating");

     $(".fa-star").click(function(){
           defualt = [0, 0, 0, 0, 0]
           var index = $(this).parent().children('.fa-star').index(this);
            for(var x = 0; x <= index; x++) {
                 defualt[x] = 1;
            }

           $.post("Php_Scripts/changeRating.php",
              {
                rating: (index + 1)
              },
              function(data, status){
                console.log("Data: " + data);
                //$('#avgRating').html();
              });

           setTimeout(function(){
               getNewAvg()
           }, 2000);

           returnToDefualt()
        });

        $(".DELETE_TEXT").click(function(){
            $("#DELETE").slideToggle();
         });

    });









function getNewAvg() {
    $.get("Php_Scripts/getAvg.php", function(data, status){
         $('#avgRating').html(data);
  });
}

function returnToDefualt() {
    $(".fa-star").removeClass("checked");
       for(var x = 0; x < defualt.length; x++) {
          if(defualt[x] == 0) {
              $(".fa-star").eq(x).removeClass("checked");
          }else{
              $(".fa-star").eq(x).addClass("checked");
          }
     }
}
