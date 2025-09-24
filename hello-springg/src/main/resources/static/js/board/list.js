/**
 * 
 */
$().ready(function(){
    //alert("!");
    // "새 글 작성" 클릭 후 페이지 이동
    $(".write-article").on("click", function(){
       window.location.href = "/write";
    });
});
