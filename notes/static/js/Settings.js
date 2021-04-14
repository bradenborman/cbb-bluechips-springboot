$(document).ready(function() {
  var token = $('meta[name="_csrf"]').attr("content");

  $.ajaxSetup({
    headers: { "X-CSRF-TOKEN": token }
  });

  $("#phoneNumber").keyup(function() {
    if ($("#phoneNumber")[0].checkValidity()) {
      $("#phoneNumber").css({
        "background-color": "#bffdc3"
      });
      makeRequestToUpdatePhoneNumber($(this).val());
      if ($(this).val() == "") $("#textAlertCheck").prop("checked", false);
    } else {
      $("#phoneNumber").css({
        "background-color": "#ffb8b8"
      });
    }
  });

  function makeRequestToUpdatePhoneNumber(phoneNumber) {
    $.post(
      "/settings/updatePhoneNumber",
      {
        phoneNumber: phoneNumber
      },
      function(data, status) {
        console.log("Data: " + data + "\nStatus: " + status);
      }
    );
  }

  $("#textAlertCheck").change(function() {
    if (
      ($("#phoneNumber")[0].checkValidity() &&
        $("#phoneNumber").val().length > 1) ||
      !this.checked
    ) {
      $.post(
        "/settings/updateTextAlert",
        {
          textStatus: this.checked
        },
        function(data, status) {
          console.log("Data: " + data + "\nStatus: " + status);
        }
      );
    } else {
      $("#textAlertCheck").prop("checked", false);
      alert("Please enter a valid phone number first.");
    }
  });

  $("#DELETE").hide();

  $(".DELETE_TEXT").click(function() {
    $("#DELETE").slideToggle();
  });
});

var areGroupsHidden = false;

function toggleCreateGroups() {
  var addIconTxt =
    '<i class="fa fa-plus" aria-hidden="true"></i> Create new group';
  var backToGroupsTxt =
    '<i class="fa fa-angle-double-left" aria-hidden="true"></i> Back to groups';

  if (!areGroupsHidden) {
    $("#addGroupDiv").show();
    $(".groups").hide(200);
    $("#addGroupToggle").html(backToGroupsTxt);
  } else {
    $("#addGroupDiv").hide();
    $(".groups").show(200);
    $("#addGroupToggle").html(addIconTxt);
  }

  areGroupsHidden = !areGroupsHidden;
}

function deleteUser() {
  $.post("/user/delete/", {}, function(data, status) {
    console.log("Data: " + data + "\nStatus: " + status);
  });
  document.getElementById("logoutForm").submit();
}

function attemptToJoinGroup(groupId, passwordReq) {
  var passwordEntered = "";

  if (passwordReq)
    passwordEntered = prompt("Please Enter Group Password:").trim();

  $.ajax({
    type: "POST",
    url: "/group/attempt-to-join",
    data: JSON.stringify({
      groupId: groupId,
      groupPassword: passwordEntered
    }),
    contentType: "application/json; charset=utf-8",
    success: function(data) {
      location.reload();
    },
    error: function(errMsg) {
      console.log(errMsg);
    }
  });
}

function attemptToLeaveGroup(groupAssocId, groupId) {
  if (
    confirm(
      "You are trying to leave a group. If you leave and attempt to rejoin, a password may be required!\nClick Okay to confirm."
    )
  ) {
    //TODO finish
    $.ajax({
      type: "POST",
      url: "/group/attempt-to-leave",
      data: JSON.stringify({
        groupAssocId: groupAssocId,
        groupId: groupId
      }),
      contentType: "application/json; charset=utf-8",
      success: function(data) {
        location.reload();
      },
      error: function(errMsg) {
        console.log(errMsg);
      }
    });
  }
}
