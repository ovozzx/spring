package com.ktdsuniversity.edu.board.vo;

import java.util.List;

// 게시글의 개수 + 게시글의 목록를 동시에 반환할 수 없어서 만듦
public class ResponseBoardListVO {
	
	private int count; // 게시글의 총개수
	private List<BoardVO> list;
	
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<BoardVO> getList() {
		return this.list;
	}
	public void setList(List<BoardVO> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ResponseBoardListVO [count=" + this.count + ", list=" + this.list + "]";
	}
	

}
