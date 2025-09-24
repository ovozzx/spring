package com.ktdsuniversity.edu.board.dao;

import java.util.List;

import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.RequestCreateBoardVO;
import com.ktdsuniversity.edu.board.vo.RequestModifyBoardVO;


public interface BoardDao {
	public int selectBoardAllCount();
	public List<BoardVO> selectBoardList();
	public int insertNewBoard(RequestCreateBoardVO requestCreateBoardVO);
	public int updateViewCntById(String id);
	public BoardVO selectBoardById(String id);
	public int updateBoardModifyById(RequestModifyBoardVO requestModifyBoardVO);
	public int deleteBoardById(String id);
	
}
