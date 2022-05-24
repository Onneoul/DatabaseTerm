package com.teammate.find.Question;

import java.util.Date;

public class Answer {
	private int questionNumber;
	private int writer;
	private String content;
	private Date date;
	private int recommendation;
	
	public Answer() {
		
	}
	
	public Answer(int questionNumber, int writer, String content, Date date, int recommendation) {
		super();
		this.questionNumber = questionNumber;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.recommendation = recommendation;
	}
	
	public int getQuestionNumber() {
		return questionNumber;
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
	
	
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
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
}
