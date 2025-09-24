package com.ktdsuniversity.edu.board.vo;

public class RequestModifyBoardVO {
	
	private String subject;
	private String email;
	private String content;
	private String id;
	
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
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RequestModifyBoardVO [subject=" + this.subject + ", email=" + this.email + ", content=" + this.content + ", id=" + this.id
				+ "]";
	}
	
	
	

}
