 $(document).ready(function(){

    var token = $('meta[name="_csrf"]').attr('content')

    $.ajaxSetup({
       headers:{ "X-CSRF-TOKEN" : token }
    });

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
   document.getElementById("logoutForm").submit();
}


function attemptToJoinGroup(groupId, passwordReq) {

        var passwordEntered = ""

        if(passwordReq)
            passwordEntered = prompt("Please Enter Group Password:").trim()

        $.ajax({
            type: "POST",
            url: "/group/attempt-to-join",
            data: JSON.stringify(
                {
                    "groupId" : groupId,
                    "groupPassword" : passwordEntered
                }
            ),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                console.log(data);
            },
            error: function(errMsg) {
                console.log(errMsg);
            }
        });
}
