package com.teammate.find.Question;

import java.util.Date;

public class Answer {
	private int questionCode;
	private int code;
	private int writer;
	private String content;
	private Date date;
	private int recommendation;
	
	public Answer() {
		
	}
	
	public Answer(int questionCode, int code, int writer, String content, Date date, int recommendation) {
		super();
		this.questionCode = questionCode;
		this.code = code;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.recommendation = recommendation;
	}
	
	public int getquestionCode() {
		return questionCode;
	}
	public int getWriter() {
		return writer;
	}
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
	public int getRecommendation() {
		return recommendation;
	}
	public int getCode() {
		return code;
	}
	
	
	public void setquestionCode(int questionCode) {
		this.questionCode = questionCode;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
