$(document).ready(function(){


	//$("#recoverPassword").hide();


	$("#email").keyup(function() {
		  shouldShowPasswordRecovery($(this).val())
	});


	$('#fnameLBL').click(function(){
	  	$('#fname').focus()
	});

	$('#lnameLBL').click(function(){
	  	$('#lname').focus()
	});

	$('#email_newLBL').click(function(){
	  	$('#email_new').focus()
	});


	$('#password_newLBL').click(function(){
	  	$('#password_new').focus()
	});


	$('#emailLBL').click(function(){
	  	$('#email').focus()
	});


	$('#passwordLBL').click(function(){
	  	$('#password').focus()
	});
});




function forgotPassword() {

	var email = $("#email").val();

	if (validateEmail(email)) {
 		location.href="https://cbbbluechips.com/Php_Scripts/recoverPassword.php?email=" + email;
	}

}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function shouldShowPasswordRecovery(email) {

	if (validateEmail(email)) {
 		$("#recoverPassword").html("Forgot Password? Click me")
	}else {
		$("#recoverPassword").html("Enter valid Email for password recovery")
	}
}
