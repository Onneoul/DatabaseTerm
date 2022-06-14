package com.teammate.find.Question;

import java.util.Date;

public class Answer {
	private int questionCode;
	private int code;
	private int writer;
	private String writerName;
	private String content;
	private String writeDate;
	private int recommendation;
	
	public Answer() {
		
	}
	
	public Answer(int questionCode, int code, int writer, String writerName, String content, String writeDate, int recommendation) {
		super();
		this.questionCode = questionCode;
		this.code = code;
		this.writer = writer;
		this.writerName = writerName;
		this.content = content;
		this.writeDate = writeDate;
		this.recommendation = recommendation;
	}
	
	public int getQuestionCode() {
		return questionCode;
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
	public int getRecommendation() {
		return recommendation;
	}
	public int getcode() {
		return code;
	}
	
	
	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
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
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	public void setcode(int code) {
		this.code = code;
	}
}
