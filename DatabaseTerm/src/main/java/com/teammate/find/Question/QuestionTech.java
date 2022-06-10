package com.teammate.find.Question;

public class QuestionTech {
	private int questionCode;
	private int techCode;
	private String techName;
	
	public QuestionTech() {
		
	}
	
	public QuestionTech(int questionCode, int techCode, String techName) {
		super();
		this.questionCode = questionCode;
		this.techCode = techCode;
		this.techName = techName;
	}
	
	public int getQuestionCode() {
		return questionCode;
	}
	public int getTechCode() {
		return techCode;
	}
	public String getTechName() {
		return techName;
	}
	
	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
	}
	public void setTechCode(int techCode) {
		this.techCode = techCode;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	
}
