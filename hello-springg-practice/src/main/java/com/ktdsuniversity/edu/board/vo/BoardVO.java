package com.ktdsuniversity.edu.board.vo;

public class BoardVO {

	String id;
	String subject;
	String content;
	String email;
	int viewCnt;
	String crtDt;
	String mdfyDt;
	String delYn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getMdfyDt() {
		return mdfyDt;
	}
	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	@Override
	public String toString() {
		return "BoardVO [id=" + this.id + ", subject=" + this.subject + ", content=" + this.content + ", email=" + this.email + ", viewCnt="
				+ this.viewCnt + ", crtDt=" + this.crtDt + ", mdfyDt=" + this.mdfyDt + ", delYn=" + this.delYn + "]";
	}
	

	
}
