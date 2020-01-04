 $(document).ready(function(){

      $("#phoneNumber").keyup(function(){

       if($("#phoneNumber")[0].checkValidity()) {
                $("#phoneNumber").css({
                    "background-color" : "#bffdc3"
                })
            makeRequestToUpdatePhoneNumber($(this).val())
            if($(this).val() == "")
                $("#textAlertCheck").prop( "checked", false );
       }
       else {
                $("#phoneNumber").css({
                   "background-color" : "#ffb8b8"
               })
       }

      });


        function makeRequestToUpdatePhoneNumber(phoneNumber) {

               $.post("/settings/updatePhoneNumber",
                   {
                     phoneNumber: phoneNumber
                   },
                   function(data,status){
                     console.log("Data: " + data + "\nStatus: " + status);
                   });

        }


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

        $(".DELETE_TEXT").click(function(){
            $("#DELETE").slideToggle();
         });

 });


function deleteUser() {
   $.post("/user/delete/", {},
       function(data,status){
         console.log("Data: " + data + "\nStatus: " + status);
   });

   location.href = "/"

}

