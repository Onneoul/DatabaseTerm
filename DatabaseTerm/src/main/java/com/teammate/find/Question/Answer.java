package com.teammate.find.Question;

import java.util.Date;

public class Answer {
	private int questionCode;
	private int answerCode;
	private int writer;
	private String content;
	private Date date;
	private int recommendation;
	
	public Answer() {
		
	}
	
	public Answer(int questionCode, int answerCode, int writer, String content, Date date, int recommendation) {
		super();
		this.questionCode = questionCode;
		this.answerCode = answerCode;
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
	public int getAnswerCode() {
		return answerCode;
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
	public void setAnswerCode(int answerCode) {
		this.answerCode = answerCode;
	}
}
