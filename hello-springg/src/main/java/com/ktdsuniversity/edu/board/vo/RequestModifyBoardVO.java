package com.ktdsuniversity.edu.board.vo;

public class RequestModifyBoardVO {
//3개의 페이로드 전달 (subject, email, content, id (path variable)) RequestModifyBoardVO에 4개 필요
	private String id;
	private String subject;
	private String email;
	private String content;
	
	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "RequestModifyBoardVO [id" + id + ", subject=" + this.subject + ", email=" + this.email + ", content=" + this.content + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
