package org.zerock.domain;

import java.util.Date;

public class BoardVO {
	private Long bno;
	private String title,content,writer;
	private Date regdate,updateDate;
	private int ReplyCnt;
	public Long getBno() {
		return bno;
	}
	public int getReplyCnt() {
		return ReplyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		ReplyCnt = replyCnt;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
