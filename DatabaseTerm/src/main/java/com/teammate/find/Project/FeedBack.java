package com.teammate.find.Project;

import org.springframework.stereotype.Repository;

@Repository
public class FeedBack {
	private int projectCode;
	private int feedBackCode;
	private int writer;
	private String writerName;
	private String content;
	private String writeDate;
		
	public FeedBack() {
			
	}
		
	public FeedBack(int projectCode, int FeedBackCode, int writer, String writerName, String content, String writeDate) {
		super();
		this.projectCode = projectCode;
		this.feedBackCode = FeedBackCode;
		this.writer = writer;
		this.writerName = writerName;
		this.content = content;
		this.writeDate = writeDate;
	}
		
	public int getProjectCode() {
		return projectCode;
	}
	public int getWriter() {
		return writer;
	}
	public String getWriterName() {
		return writerName;
	}
	public String getContent() {
		return content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public int getFeedBackCode() {
		return feedBackCode;
	}
		
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public void setFeedBackCode(int FeedBackCode) {
		this.feedBackCode = FeedBackCode;
	}
}
