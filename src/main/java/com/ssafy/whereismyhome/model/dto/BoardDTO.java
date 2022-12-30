package com.ssafy.whereismyhome.model.dto;


public class BoardDTO {
	private int boardNo;
	private String userId;
	private String subject;
	private String content;

	private int type;
	private String registerTime;

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "NoticeDTO [boardNo=" + boardNo + ", userId=" + userId + ", subject=" + subject + ", content="
				+ content + ", registerTime=" + registerTime + "]";
	}
	
}
