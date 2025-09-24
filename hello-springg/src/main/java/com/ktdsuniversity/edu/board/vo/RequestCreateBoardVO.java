package com.ktdsuniversity.edu.board.vo;

import org.springframework.web.multipart.MultipartFile;

public class RequestCreateBoardVO {

	private MultipartFile file;
	private String id;
	private String subject;
	private String email;
	private String content;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		return "RequestCreateBoardVO [id=" + id + ", subject=" + subject + ", email=" + email + ", content=" + content
				+ "]";
	}
	

	
}
