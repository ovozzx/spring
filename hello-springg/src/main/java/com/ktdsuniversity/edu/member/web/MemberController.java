package com.ktdsuniversity.edu.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.common.vo.AjaxResponse;
import com.ktdsuniversity.edu.member.service.MemberService;
import com.ktdsuniversity.edu.member.vo.RequestRegistMemberVO;

import jakarta.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @GetMapping("/member/regist")
    public String viewMemberRegistPage() {
    	return "member/regist";
    }
    
    @PostMapping("/member/regist")
    public String doMemberRegistAction(@Valid RequestRegistMemberVO requestRegistMemberVO, // 한번에 받아오는 커맨드 오브젝트
    		                            BindingResult bindingResult,
    		                            Model model) { 
    	
    	 if(bindingResult.hasErrors()) {
    		 model.addAttribute("registData", requestRegistMemberVO);
    		 return "member/regist";
    	 }
    	 
    	 // 패스워드 일치검사
    	 if(! requestRegistMemberVO.getPassword()
    			 .equals(requestRegistMemberVO.getPasswordConfirm())) {
    		 model.addAttribute("registData", requestRegistMemberVO);
    		 model.addAttribute("passwordError", "비밀번호가 일치하지 않습니다.");
    		 return "member/regist";
    	 }
    	 
    	 boolean createResult = this.memberService.createNewMember(requestRegistMemberVO);
    	 
    	 return "redirect:/member/login";
    }    
    
    @ResponseBody // return한 게 view가 아니라 data 다! (없으면 view가 됨)
    @GetMapping("/member/regist/check") // 쿼리 스트링 파라미터는 쓰지 않음
    public AjaxResponse doDuplicateCheckAction(@RequestParam String email) { // 1개만 가져오기에 @RequestParam로
    	
    	int count = this.memberService.readMemberCountByEmail(email);
    	
    	AjaxResponse ajaxResponse = new AjaxResponse();
    	ajaxResponse.setBody(count);
    	
    	return ajaxResponse;
    }
    

}