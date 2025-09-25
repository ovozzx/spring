package com.ktdsuniversity.edu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.RequestCreateBoardVO;
import com.ktdsuniversity.edu.board.vo.RequestModifyBoardVO;
import com.ktdsuniversity.edu.board.vo.ResponseBoardListVO;

import jakarta.validation.Valid;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardServie;
	
	// (1) 게시판 cnt + 리스트 조회 
	@GetMapping("/list")
	public String viewBoardListPage(Model model) {
		
		ResponseBoardListVO result = this.boardServie.readBoardList();
		
		model.addAttribute("list", result);
		
		return "board/list";
		
//	    <div>검색된 게시글의 수 : ${list.count} 개</div>
//	    <div>검색 결과 ${list.list}</div>
	}
	
	// (2) 게시판 등록 화면 
	@GetMapping("/write")
	public String viewBoardWritePage() {
		
	    // 암것도 없음
		return "board/write";
	}
	
	// (3) 게시판 등록하기 => 등록 버튼 누르는 걸 어케하는지
	@PostMapping("/write")
	public String doWriteBoardAction(@Valid RequestCreateBoardVO requestCreateBoardVO,
			                         BindingResult bindingResult,
			                         Model model) { // 여기서는 파라미터 순서지켜야됨. 실패한 내용만 bindingResult에 보내줌 
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("writeData", requestCreateBoardVO);
			return "board/write";
		}
		
		// 등록하기 눌렀을 때 insert > 
		boolean writeResult = this.boardServie.createNewBoard(requestCreateBoardVO);
		
		
//		requestCreateBoardVO.setId();
//		return "/board/view";
		return "redirect:/view/" + requestCreateBoardVO.getId(); // 다른 url로 보냄
	}
	
	// (4) 특정 id 게시글 조회하기
	@GetMapping("/view/{id}")
	public String viewBoardDetailPage(@PathVariable String id,  Model model) {
		
		BoardVO board = this.boardServie.readBoardOneById(id, true); // 조회 수 늘어남
		
		model.addAttribute("board", board);
		
		System.out.println(board);
		
		return "board/view";
	}
	
	///////////////////////////////////////////////////////////
	// (5) 게시판 수정 화면
	@GetMapping("/modify/{id}")
    public String viewModifyBoardPage(@PathVariable String id, Model model) {
		
//		boolean modifyResult = this.boardServie.updateBoardModifyById(requestModifyBoardVO);
		BoardVO board = this.boardServie.readBoardOneById(id, false); 
		model.addAttribute("board", board);
		
		return "board/modify";
//		return "redirect:/view/" + requestModifyBoardVO.getId();
	}
	
	// (6) 게시판 수정하기 
	@PostMapping("/modify/{id}")
    public String doModifyBoardAction(@PathVariable String id, RequestModifyBoardVO requestModifyBoardVO) {
		
		requestModifyBoardVO.setId(id); // form에 포함 안되어있어서 따로 받아 옴
		
		boolean modifyResult = this.boardServie.updateBoardModifyById(requestModifyBoardVO);
		// 수정이 완료되면 "/list" URL로 이동시킨다.
		return "redirect:/list";
//		return "redirect:/view/" + requestModifyBoardVO.getId();
	}	
	
	// (7) 게시판 삭제 
	@GetMapping("/delete/{id}")
    public String doDeleteBoardAction(@PathVariable String id) {
		
		boolean deleteResult = this.boardServie.deleteBoardById(id);
		
		return "redirect:/list"; // 이동시키기
	}
	
}
