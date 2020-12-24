 $(document).ready(function(){

    var token = $('meta[name="_csrf"]').attr('content')
    $.ajaxSetup({
       headers:{ "X-CSRF-TOKEN" : token }
    });

 });

function deleteGroup(groupId) {

    if(confirm("Are you sure you want to delete " + groupId)) {
        $.ajax({
            type: "POST",
            url: "/admin/delete-group",
            data: JSON.stringify(
                {
                    "groupId" : groupId
                }
            ),
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