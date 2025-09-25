package com.ktdsuniversity.edu.file.vo;

import org.springframework.web.bind.annotation.PathVariable;

public class RequestDownloadVO {
	private String boardId;
	private String fileGroupId;
	private String fileId;
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getFileGroupId() {
		return fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	@Override
	public String toString() {
		return "RequestDownloadVO [boardId=" + this.boardId + ", fileGroupId=" + this.fileGroupId + ", fileId=" + this.fileId + "]";
	}
	
	

}
