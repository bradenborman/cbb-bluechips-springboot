$(document).ready(function(){

  $(".icon-remove").click(function(){

            var ID = $(this).attr("id");
            var isParentComment = true;
            var CommentId = ""
             if(ID.indexOf("sub") !== -1)
                 isParentComment = false;
             CommentId = ID.substring(3)

             console.log("Is parent: " + isParentComment + " CommentId: " + CommentId)
            requestDeleteComment(isParentComment, CommentId);
            $(this).closest('.media-body').css({"color": "red"});
   });



   $(".showSubCommentsBtn").click(function(){
      $(this)
        .nextAll(".subcommentsGrouped")
        .children(".morethan2Subs").toggle(400);
   });



});


function requestDeleteComment(isParentComment, CommentId) {

         $.post("/comments/deleteComment",
                {
                  isParentComment: isParentComment,
                  CommentId: CommentId
                },
                function(data,status){
                  console.log("Status: " + status);
          });

}