/**
 * 
 */

$().ready(function(){
    
    $(".add-file").on("click", function(){
        var newFile = $("<input />");
        newFile.attr("type", "file");
        newFile.attr("name", "file"); /* 이름 똑같으면 컬렉션 만들어짐 -> 자바에서 리스트로 받아올 수 있음 */
        $(".vertical-flex").append(newFile);
        
    });
   
});