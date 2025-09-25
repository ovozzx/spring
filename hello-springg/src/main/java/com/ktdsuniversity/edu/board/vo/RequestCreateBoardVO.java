package com.ktdsuniversity.edu.board.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RequestCreateBoardVO {

	private List<MultipartFile> file; /// 여러개 파일 받음
	
	private String id;
	@NotEmpty(message = "필수 입력입니다.") // 비었을 때, 보여줄 메세지
	private String subject; // 필수값
	@NotEmpty(message = "필수 입력입니다.")
	@Email(message = "이메일 형태로 작성하세요.")
	private String email; // 필수값
	@NotEmpty(message = "필수 입력입니다.")
	private String content; // 필수값
	private String fileGroupId;
	

	public String getFileGroupId() {
		return fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
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
