/**
 * 
 */
$().ready(function() {
    $(".save-btn").on("click", function(){ // disable 상태에서는 동작 안 함!
        $("#requestRegistMemberVO").submit(); // form 태그를 서버로 전송!
        // modelAttribute = requestRegistMemberVO 값이 form id로 들어감
    });
    
    $("#email").on("keyup", function(){ //  $(this) function을 수행한 대상
        var value = $(this).val(); 
        console.log(value);
        
        
        var validateErrorCount = $(this).closest("div").find(".validate-error").not(".not-ok").length;
        
        if(validateErrorCount > 0){
            $(this).closest("div").find("span.not-ok").remove();
            $(this).closest("div").find("span.ok").remove();
            return; // 이벤트를 종료해라 (아래 요청도 안보냄)
        }
        
        var that = this;
        
        $.get("/member/regist/check?email=" + value, function(response) {
            
            var emailCount = response.body;
            
            // $(this) // 위 (var value = $(this).val();) 에서의 this와 여기서의 this는 다름 
            // $(this) function을 수행한 대상
            // 둘중에 하나만 보이게 (다른 하나를 지움)
            if(emailCount === 0){
                $(that).closest("div").find("span.not-ok").remove();
                var okCount = $(that).closest("div").find("span.ok").length;
                if(okCount === 0){                    
                    $(that).after($("<span class='ok'>사용 가능한 이메일입니다.</span>"));
                    autoActive();
                }
            }
            else{
                $(that).closest("div").find("span.ok").remove();
                var notOkCount = $(that).closest("div").find("span.not-ok").length;
                if(notOkCount === 0){ 
                    $(that).after($("<span class='validate-error not-ok'>이미 사용중인 이메일입니다.</span>"));
                    // 위에 validate-error을 클래스명으로 주면서 중복 이메일일 때, 등록 버튼 비활성화됨
                    autoActive();
                }
            }
            
        });
        
    })
});