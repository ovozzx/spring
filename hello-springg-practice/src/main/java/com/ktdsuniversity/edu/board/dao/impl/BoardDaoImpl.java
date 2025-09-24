package com.ktdsuniversity.edu.board.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.RequestCreateBoardVO;
import com.ktdsuniversity.edu.board.vo.RequestModifyBoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}; // 
	
	@Override
	public int selectBoardAllCount() {
		return super.getSqlSession().selectOne("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "selectBoardAllCount");
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return super.getSqlSession().selectList("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "selectBoardList");
	}

	@Override
	public int insertNewBoard(RequestCreateBoardVO requestCreateBoardVO) {
		return super.getSqlSession().insert("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "insertNewBoard", requestCreateBoardVO);
	}

	@Override
	public BoardVO selectBoardById(String id) {
		return super.getSqlSession().selectOne("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "selectBoardById", id);
	}

	@Override
	public int updateViewCntById(String id) {
		return super.getSqlSession().update("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "updateViewCntById", id);
	}

	@Override
	public int updateBoardModifyById(RequestModifyBoardVO requestModifyBoardVO) {
		
		return super.getSqlSession().update("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "updateBoardModifyById", requestModifyBoardVO);

	}

	@Override
	public int deleteBoardById(String id) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("com.ktdsuniversity.edu.board.dao.impl.BoardDaoImpl." + "deleteBoardById", id);

	}

}
