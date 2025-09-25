package com.ktdsuniversity.edu.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.RequestCreateBoardVO;
import com.ktdsuniversity.edu.board.vo.RequestModifyBoardVO;
import com.ktdsuniversity.edu.board.vo.ResponseBoardListVO;
import com.ktdsuniversity.edu.file.dao.FileDao;
import com.ktdsuniversity.edu.file.dao.FileGroupDao;
import com.ktdsuniversity.edu.file.util.MultipartFileHandler;
import com.ktdsuniversity.edu.file.vo.FileGroupVO;
import com.ktdsuniversity.edu.file.vo.FileVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired // bean 컨테이너 객체를 가져와라!
	private MultipartFileHandler multipartFileHandler;
	@Autowired // 이걸 쓰려면 다른 에노테이션 
    private BoardDao boardDao;	
	
	@Autowired
    private FileGroupDao fileGroupDao;	
	
	@Autowired 
    private FileDao fileDao;	
	
	@Override
	public ResponseBoardListVO readBoardList() {
		
		ResponseBoardListVO result = new ResponseBoardListVO();
		
		int count = this.boardDao.selectBoardAllCount();
		List<BoardVO> list = this.boardDao.selectBoardList();
		
		result.setCount(count);
		result.setList(list);
		
		return result;
	}

	@Override
	public boolean createNewBoard(RequestCreateBoardVO requestCreateBoardVO) { // 첨부파일 여러개 업로드 시, DB에 FILE_GROUP_ID 동일한 게 여러 개 들어옴
		// 업로드해줘
		List<FileVO> uploadResult = this.multipartFileHandler.upload(requestCreateBoardVO.getFile()); // getFile이 리스트 -> upload가 리스트 파라마티터 받도록 만듦
//		System.out.println(uploadResult);
		
		// 1. File Group Insert
		if(uploadResult != null && uploadResult.size() > 0) { // && 리스트 개수가 1개 이상일 때부터 
			FileGroupVO fileGroupVO = new FileGroupVO();
			fileGroupVO.setFileCount(uploadResult.size());
//			fileGroupVO.setFileCount(uploadResult != null ? 1 : 0);
			int insertFileGroupCount = this.fileGroupDao.insertFileGroup(fileGroupVO);
			
			// 2. File Insert
			for(FileVO result : uploadResult) {	
				result.setFileGroupId(fileGroupVO.getFileGroupId());
				int insertFileCount = this.fileDao.insertFile(result);
			}
			
			requestCreateBoardVO.setFileGroupId(fileGroupVO.getFileGroupId());
		}
		// boardDao를 통해서 insert를 수행시킨다
		// 그 결과를 반환시킨다
		return this.boardDao.insertNewBoard(requestCreateBoardVO) > 0;
	}

	@Override
	public BoardVO readBoardOneById(String id, boolean doIncreaseViewCount) {
		
//		BoardVO result = new BoardVO();
		// 조회수 증가 -> 조회 순서가 맞음
		if (doIncreaseViewCount) {
			int updateCount = this.boardDao.updateViewCntById(id);
			if (updateCount == 0) {
				throw new IllegalArgumentException(id + " 게시글은 존재하지 않습니다.");
			}
		}
		
		// 2. 게시글의 내용을 조회한다.
		BoardVO board = this.boardDao.selectBoardById(id);
		if (board == null) {
			throw new IllegalArgumentException(id + " 게시글은 존재하지 않습니다.");
		}
		
		// 3. 게시글의 내용을 반환시킨다.
		return board;
	}

	@Override
	public boolean updateBoardModifyById(RequestModifyBoardVO requestModifyBoardVO) {
		int updateCount = this.boardDao.updateBoardModifyById(requestModifyBoardVO);
		
		if (updateCount == 0) {
			throw new IllegalArgumentException(requestModifyBoardVO.getId() + " 게시글은 존재하지 않습니다.");
		}
		
		return updateCount > 0;
	}

	@Override
	public boolean deleteBoardById(String id) {
		int deleteCount = this.boardDao.deleteBoardById(id);
		if (deleteCount == 0) {
			throw new IllegalArgumentException(id + " 게시글은 존재하지 않습니다.");
		}
		
		return deleteCount > 0;
	}

}
